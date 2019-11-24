package com.elfak.eclassroom.data.base.repository.impl;

import com.elfak.eclassroom.data.config.HibernateManager;
import com.elfak.eclassroom.data.base.repository.BaseRepository;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

public abstract class BaseRepositoryImpl<K extends Serializable, T> implements BaseRepository<K, T> {

    private static final Logger LOGGER = Logger.getLogger(BaseRepository.class.getName());

    private final SessionFactory sessionFactory;

    private final Class<T> type;

    public BaseRepositoryImpl(Class<T> type) {
        sessionFactory = HibernateManager.getSessionFactory();
        this.type = type;
    }

    @Override
    public Optional<T> createOrUpdate(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(entity);
            transaction.commit();
            return Optional.ofNullable(entity);
        } catch (Exception ex) {
            LOGGER.warning("Error when creating or updating type: " + type.getName() + ", " + ex.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<T> getById(K id) {
        try (Session session = sessionFactory.openSession()) {
            T entity = session.find(type, id);
            session.detach(entity);
            return Optional.ofNullable(entity);
        } catch (Exception ex) {
            LOGGER.warning("Error when fetching type: " + type.getName() + ", " + ex.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Set<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
            CriteriaQuery<T> all = criteriaQuery.select(criteriaQuery.from(type));
            return new HashSet<>(session.createQuery(all).getResultList());
        } catch (Exception ex) {
            LOGGER.warning("Error when fetching type: " + type.getName() + ", " + ex.getMessage());
        }
        return new HashSet<>();
    }

    @Override
    public Set<T> getAllByIds(Set<K> ids) {
        try (Session session = sessionFactory.openSession()) {
            MultiIdentifierLoadAccess<T> tMultiIdentifierLoadAccess = session.byMultipleIds(type);
            return new HashSet<>(tMultiIdentifierLoadAccess.multiLoad(new ArrayList<>(ids)));
        } catch (Exception ex) {
            LOGGER.warning("Error when multiple fetching of type: " + type.getName() + ", " + ex.getMessage());
        }
        return new HashSet<>();
    }

    @Override
    public Optional<T> delete(K id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            T entity = session.get(type, id);
            session.delete(entity);
            transaction.commit();
            return Optional.ofNullable(entity);
        } catch (Exception ex) {
            LOGGER.warning("Error when deleting of type: " + type.getName() + ", " + ex.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}