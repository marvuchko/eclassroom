package com.elfak.eclassroom.resource.lecture;

import com.elfak.eclassroom.data.lecture.entity.Video;
import com.elfak.eclassroom.data.lecture.entity.VideoThread;
import com.elfak.eclassroom.dto.lecture.VideoThreadDto;
import com.elfak.eclassroom.resource.base.BaseResource;
import com.elfak.eclassroom.service.lecture.ThreadService;
import com.elfak.eclassroom.service.lecture.VideoService;
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

@Path(VideoThreadResource.BASE_URL)
@Tag(name = "Threads")
public class VideoThreadResource extends BaseResource {

    static final String BASE_URL = "video/{videoId}/thread";

    private VideoService videoService;
    private ThreadService threadService;

    @GET
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = VideoThreadDto.class)
                    )
            ),
            description = "Fetches all threads for a specified video."
    )
    public Response getAll(@PathParam("videoId") UUID videoId) {
        Optional<Video> video = videoService.getById(videoId);
        if (video.isPresent()) return listResponse(video.get().getVideoThreads(), VideoThreadDto.class);
        return Response.noContent().build();
    }

    @GET
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VideoThreadDto.class)
            ),
            description = "Fetches single thread for a specified video by id."
    )
    @Path(ID_PATH)
    public Response getSingle(@PathParam("videoId") UUID videoId, @PathParam("id") UUID id) {
        if (!videoService.getById(videoId).isPresent()) return Response.noContent().build();
        Optional<VideoThread> thread = threadService.getById(id);
        if (thread.isPresent()) return entityResponse(thread.get(), VideoThreadDto.class);
        return Response.noContent().build();
    }

    @DELETE
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VideoThreadDto.class)
            ),
            description = "Fetches all threads from the database."
    )
    @Path(ID_PATH)
    public Response delete(@PathParam("videoId") UUID videoId, @PathParam("id") UUID id) {
        if (!videoService.getById(videoId).isPresent()) return Response.noContent().build();
        Optional<VideoThread> thread = threadService.delete(id);
        if (thread.isPresent()) return entityResponse(thread.get(), VideoThreadDto.class);
        return Response.noContent().build();
    }

    @POST
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VideoThreadDto.class)
            ),
            description = "Creates a new thread for a video."
    )
    public Response create(@PathParam("videoId") UUID videoId, VideoThreadDto body) {
        Optional<Video> videoResult = videoService.getById(videoId);
        if (videoResult.isPresent()) return Response.noContent().build();
        Video video = videoResult.get();
        VideoThread thread = (VideoThread) map(body, VideoThread.class);
        thread.setVideo(video);
        Optional<VideoThread> threadResult = threadService.createOrUpdate(thread);
        if (threadResult.isPresent()) return entityResponse(threadResult.get(), VideoThreadDto.class);
        return Response.noContent().build();
    }

    @Inject
    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }

    @Inject
    public void setThreadService(ThreadService threadService) {
        this.threadService = threadService;
    }
}
