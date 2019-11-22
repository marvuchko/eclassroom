package com.elfak.eclassroom.data.base.repository;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public interface BaseRepository<K extends Serializable, T> {

    Optional<T> createOrUpdate(T entity);

    Optional<T> getById(K id);

    Set<T> getAll();

    Set<T> getAllByIds(Set<K> ids);

    Optional<T> delete(K id);
    
}