package com.elfak.eclassroom.resource.file;

import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static com.elfak.eclassroom.service.constants.ServiceEnvironment.UPLOAD_DIR;

@Path(FileResource.BASE_PATH)
@Tag(name = "Media Files")
public class FileResource {

    static final String BASE_PATH = "/files";
    private static final String FILE_NAME_PATH = "/{fileName}";
    private static final String LOCAL_UPLOAD_DIR = "/home/wizard-of-tomorrow/eclassroom/";

    @GET
    @Path(FILE_NAME_PATH)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getMedia(@PathParam("fileName") String fileName) {
        StreamingOutput fileStream = output -> {
            try {
                java.nio.file.Path path = Paths.get(Optional
                        .ofNullable(System.getenv(UPLOAD_DIR))
                        .orElse(LOCAL_UPLOAD_DIR) + "/" + fileName);
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception e) {
                throw new WebApplicationException("File Not Found !!");
            }
        };

        return Response.ok(fileStream).build();
    }

}
