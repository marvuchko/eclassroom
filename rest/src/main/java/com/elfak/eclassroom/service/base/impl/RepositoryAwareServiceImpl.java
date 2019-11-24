package com.elfak.eclassroom.service.base.impl;

import com.elfak.eclassroom.data.base.repository.BaseRepository;
import com.elfak.eclassroom.service.base.RepositoryAwareService;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public abstract class RepositoryAwareServiceImpl<K extends Serializable, T, R extends BaseRepository<K, T>>
        implements RepositoryAwareService<K, T, R> {

    private final R repository;

    public RepositoryAwareServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public Optional<T> createOrUpdate(T entity) {
        return repository.createOrUpdate(entity);
    }

    @Override
    public Optional<T> getById(K id) {
        return repository.getById(id);
    }

    @Override
    public Set<T> getAll() {
        return repository.getAll();
    }

    @Override
    public Set<T> getAllByIds(Set<K> ids) {
        if (ids.isEmpty()) return repository.getAll();
        return repository.getAllByIds(ids);
    }

    @Override
    public Optional<T> delete(K id) {
        return repository.delete(id);
    }

    @Override
    public R getRepository() {
        return repository;
    }
}
