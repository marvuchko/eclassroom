package com.elfak.eclassroom.resource.base.impl;

import com.elfak.eclassroom.data.base.repository.BaseRepository;
import com.elfak.eclassroom.resource.base.ServiceAwareResource;
import com.elfak.eclassroom.service.base.RepositoryAwareService;

import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public abstract class ServiceAwareResourceImpl<K extends Serializable, T, R extends BaseRepository<K, T>, S extends RepositoryAwareService<K, T, R>>
        implements ServiceAwareResource<K, T, R, S> {

    private final S service;

    protected ServiceAwareResourceImpl(S service) {
        this.service = service;
    }

    @Override
    public Response createOrUpdate(T entity) {
        return getOrNoContent(service.createOrUpdate(entity));
    }

    @Override
    public Response getById(K id) {
        return getOrNoContent(service.getById(id));
    }

    @Override
    public Response getAll(Set<K> ids) {
        if (Objects.nonNull(ids)) return getOrNoContent(service.getAllByIds(ids));
        return getOrNoContent(service.getAll());
    }

    @Override
    public Response delete(K id) {
        Optional<T> result = service.delete(id);
        if (result.isPresent()) return Response.ok(result.get()).build();
        return Response.noContent().build();
    }

    private Response getOrNoContent(Optional<T> result) {
        if (result.isPresent()) return Response.ok(result.get()).build();
        return Response.noContent().build();
    }

    private Response getOrNoContent(Set<T> result) {
        if (!result.isEmpty()) return Response.ok(result).build();
        return Response.noContent().build();
    }
}
