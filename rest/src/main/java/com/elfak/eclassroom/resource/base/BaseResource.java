package com.elfak.eclassroom.resource.base;

import org.modelmapper.ModelMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class BaseResource {

    protected static final String ID_PATH = "/{id}";

    private final ModelMapper modelMapper = new ModelMapper();

    protected Object map(Object source, Class<?> destination) {
        return modelMapper.map(source, destination);
    }

    protected Set<?> map(Set<?> source, Class<?> destination) {
        return source.stream().map(element -> map(element, destination)).collect(toSet());
    }

    protected Response entityResponse(Object source, Class<?> destination) {
        return Response.ok(modelMapper.map(source, destination)).build();
    }

    protected Response listResponse(Set<?> source, Class<?> destination) {
        Set<?> collect = source.stream().map(element -> map(element, destination)).collect(toSet());
        return Response.ok(collect).build();
    }

    protected String getServerPath(UriInfo uri) {
        return uri.getBaseUri() + "files";
    }

}
