package com.elfak.eclassroom.data.base.repository.impl;

import com.elfak.eclassroom.data.base.hibernate.HibernateSession;
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

    private final SessionFactory sessionfFactory;

    private final Class<T> type;

    public BaseRepositoryImpl( Class<T> type) {
        sessionfFactory = HibernateSession.getSessionFactory();
        this.type = type;
    }

    @Override
    public Optional<T> createOrUpdate(T entity) {
        Session session = sessionfFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(entity);
            Optional<T> optional = Optional.ofNullable(entity);
            return optional;
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
        Session session = sessionfFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Optional<T> optional = Optional.ofNullable(session.get(type, id));
            return optional;
        } catch (Exception ex) {
            LOGGER.warning("Error when fetching type: " + type.getName() + ", " + ex.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public Set<T> getAll() {
        Session session = sessionfFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = criteriaBuilder.createQuery(type);
            return new HashSet<>(session.createQuery(query).getResultList());
        } catch (Exception ex) {
            LOGGER.warning("Error when fetching type: " + type.getName() + ", " + ex.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
        return new HashSet<>();
    }

    @Override
    public Set<T> getAllByIds(Set<K> ids) {
        Session session = sessionfFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            MultiIdentifierLoadAccess<T> tMultiIdentifierLoadAccess = session.byMultipleIds(type);
            return new HashSet<>(tMultiIdentifierLoadAccess.multiLoad(new ArrayList<>(ids)));
        } catch (Exception ex) {
            LOGGER.warning("Error when multiple fetching of type: " + type.getName() + ", " + ex.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
        return new HashSet<>();
    }

    @Override
    public Optional<T> delete(K id) {
        Session session = sessionfFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            T entity = session.get(type, id);
            session.delete(entity);
            Optional<T> optional = Optional.ofNullable(entity);
            return optional;
        } catch (Exception ex) {
            LOGGER.warning("Error when deleting of type: " + type.getName() + ", " + ex.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
        return Optional.empty();
    }

}