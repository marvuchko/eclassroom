package com.elfak.eclassroom.data.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

import static com.elfak.eclassroom.data.constants.DataEnvirnoment.*;

public class HibernateManager {

    private static final Logger LOGGER = Logger.getLogger(HibernateManager.class.getName());

    private static SessionFactory sessionFactory;

    private static StandardServiceRegistry registry;

    public static SessionFactory getSessionFactory() {
        if (Objects.nonNull(sessionFactory))
            return sessionFactory;

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        try {
            Configuration configuration = new Configuration();

            Properties settings = getSettings();
            configuration.setProperties(settings);
            HibernateAnnotatedClasses.setAnnotatedClasses(configuration);
            registryBuilder.applySettings(configuration.getProperties());

            registry = registryBuilder.build();

            sessionFactory = configuration.buildSessionFactory();
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
        settings.put(Environment.URL, "jdbc:postgresql://" +
                Optional.ofNullable(System.getenv(DB_URL)).orElse("localhost") + ":" +
                Optional.ofNullable(System.getenv(DB_PORT)).orElse("5432") + "/" +
                Optional.ofNullable(System.getenv(DB_NAME)).orElse("eclassroom"));
        settings.put(Environment.USER, Optional
                .ofNullable(System.getenv(DB_USER))
                .orElse("root"));
        settings.put(Environment.PASS, Optional
                .ofNullable(System.getenv(DB_PASSWORD))
                .orElse("root"));
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        settings.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, "true");
        return settings;
    }

}