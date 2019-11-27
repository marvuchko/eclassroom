package com.elfak.eclassroom.resource.base;

import org.modelmapper.ModelMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class BaseResource {

    protected static final String ID_PATH = "/{id}";
    private static final ModelMapper modelMapper = new ModelMapper();
    @Context
    protected UriInfo uriInfo;

    protected Object map(Object source, Class<?> destination) {
        return modelMapper.map(source, destination);
    }

    protected Set<?> map(Set<?> source, Class<?> destination) {
        return source.stream().map(element -> map(element, destination)).collect(toSet());
    }

    protected Response entityResponse(Object source, Class<?> destination) {
        return Response.ok(map(source, destination)).build();
    }

    protected Response listResponse(Set<?> source, Class<?> destination) {
        return Response.ok(map(source, destination)).build();
    }

    protected String getServerFilePath() {
        return uriInfo.getBaseUri() + "files";
    }

}
