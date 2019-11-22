package com.elfak.eclassroom.service.base;

import com.elfak.eclassroom.data.base.repository.BaseRepository;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public interface RepositoryAwareService<K extends Serializable, T, R extends BaseRepository<K, T>> {

    Optional<T> createOrUpdate(T entity);

    Optional<T> getById(K id);

    Set<T> getAll();

    Set<T> getAllByIds(Set<K> ids);

    Optional<T> delete(K id);

}
