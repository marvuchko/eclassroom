package com.elfak.eclassroom.data.base.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

public class HibernateSession {

    private static final Logger LOGGER = Logger.getLogger(HibernateSession.class.getName());

    private static SessionFactory sessionFactory;

    private static StandardServiceRegistry registry;

    public static SessionFactory getSessionFactory() {
        if (Objects.nonNull(sessionFactory))
            return sessionFactory;

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        try {
            registryBuilder.applySettings(getSettings());

            registry = registryBuilder.build();

            MetadataSources sources = new MetadataSources(registry);

            Metadata metadata = sources.getMetadataBuilder().build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception ex) {
            LOGGER.warning("Exception was thrown when connecting to database: " + ex.getMessage());
            if (Objects.nonNull(registry)) {
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }

        return sessionFactory;
    }

    private static Properties getSettings() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.postgresql.Driver");
        settings.put(Environment.URL, "jdbc:postgresql://" + Optional
                .ofNullable(System.getenv("DB_URL") + ":" +
                        System.getenv("DB_PORT") + "/" +
                        System.getenv("DB_NAME"))
                .orElse("localhost:5432/eclassroom"));
        settings.put(Environment.USER, Optional
                .ofNullable(System.getenv("DB_USER"))
                .orElse("root"));
        settings.put(Environment.PASS, Optional
                .ofNullable(System.getenv("DB_PASSWORD"))
                .orElse("root"));
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
        return settings;
    }

    public static void shutdown() {
        if (Objects.isNull(registry))
            return;
        StandardServiceRegistryBuilder.destroy(registry);
    }

}