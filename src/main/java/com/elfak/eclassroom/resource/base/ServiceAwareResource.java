package com.elfak.eclassroom.resource.base;

import com.elfak.eclassroom.data.base.repository.BaseRepository;
import com.elfak.eclassroom.service.base.RepositoryAwareService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Set;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ServiceAwareResource<K extends Serializable, T, R extends BaseRepository<K, T>, S extends RepositoryAwareService<K, T, R>> {

    @PUT
    Response createOrUpdate(T entity);

    @GET
    @Path("/{id}")
    Response getById(@PathParam("id") K id);

    @GET
    @Path("/list")
    Response getAll(@QueryParam("ids") Set<K> ids);

    @DELETE
    @Path("/{id}")
    Response delete(K id);

}
