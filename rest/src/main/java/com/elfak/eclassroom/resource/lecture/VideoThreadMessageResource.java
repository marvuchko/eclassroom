package com.elfak.eclassroom.resource.lecture;

import com.elfak.eclassroom.data.lecture.entity.VideoThread;
import com.elfak.eclassroom.data.lecture.entity.VideoThreadMessage;
import com.elfak.eclassroom.dto.lecture.VideoThreadDto;
import com.elfak.eclassroom.dto.lecture.VideoThreadMessageDto;
import com.elfak.eclassroom.resource.base.BaseResource;
import com.elfak.eclassroom.service.lecture.ThreadMessageService;
import com.elfak.eclassroom.service.lecture.ThreadService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.UUID;

@Path(VideoThreadMessageResource.BASE_PATH)
@Tag(name = "Thread Messages")
public class VideoThreadMessageResource extends BaseResource {

    static final String BASE_PATH = "/thread/{threadId}/message";

    private ThreadService threadService;
    private ThreadMessageService threadMessageService;

    @GET
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = VideoThreadMessageDto.class)
                    )
            ),
            description = "Fetches all messages for a specified thread."
    )
    public Response getAll(@PathParam("threadId") UUID threadId) {
        Optional<VideoThread> thread = threadService.getById(threadId);
        if (thread.isPresent()) return listResponse(thread.get().getMessages(), VideoThreadMessageDto.class);
        return Response.noContent().build();
    }

    @GET
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VideoThreadMessageDto.class)
            ),
            description = "Fetches single message for a specified thread by id."
    )
    @Path(ID_PATH)
    public Response getSingle(@PathParam("threadId") UUID threadId, @PathParam("id") UUID id) {
        if (!threadService.getById(threadId).isPresent()) return Response.noContent().build();
        Optional<VideoThreadMessage> message = threadMessageService.getById(id);
        if (message.isPresent()) return entityResponse(message.get(), VideoThreadMessageDto.class);
        return Response.noContent().build();
    }

    @DELETE
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VideoThreadMessageDto.class)
            ),
            description = "Deletes single message of a thread from the database."
    )
    @Path(ID_PATH)
    public Response delete(@PathParam("threadId") UUID threadId, @PathParam("id") UUID id) {
        if (!threadService.getById(threadId).isPresent()) return Response.noContent().build();
        Optional<VideoThreadMessage> message = threadMessageService.delete(id);
        if (message.isPresent()) return entityResponse(message.get(), VideoThreadMessageDto.class);
        return Response.noContent().build();
    }

    @POST
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VideoThreadMessageDto.class)
            ),
            description = "Creates a new message for a thread."
    )
    public Response create(@PathParam("threadId") UUID threadId, VideoThreadMessageDto body) {
        Optional<VideoThread> threadResult = threadService.getById(threadId);
        if (threadResult.isPresent()) return Response.noContent().build();
        VideoThread thread = threadResult.get();
        VideoThreadMessage message = (VideoThreadMessage) map(body, VideoThreadMessageDto.class);
        message.setVideoThread(thread);
        Optional<VideoThreadMessage> messageResult = threadMessageService.createOrUpdate(message);
        if (messageResult.isPresent()) return entityResponse(messageResult.get(), VideoThreadMessageDto.class);
        return Response.noContent().build();
    }

    @Inject
    public void setThreadMessageService(ThreadMessageService threadMessageService) {
        this.threadMessageService = threadMessageService;
    }
    
    @Inject
    public void setThreadService(ThreadService threadService) {
        this.threadService = threadService;
    }


}
