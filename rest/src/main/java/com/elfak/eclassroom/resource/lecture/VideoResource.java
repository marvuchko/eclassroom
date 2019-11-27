package com.elfak.eclassroom.resource.lecture;

import com.elfak.eclassroom.data.lecture.entity.Lecture;
import com.elfak.eclassroom.data.lecture.entity.Video;
import com.elfak.eclassroom.dto.file.FileInfo;
import com.elfak.eclassroom.dto.lecture.VideoDto;
import com.elfak.eclassroom.resource.base.BaseResource;
import com.elfak.eclassroom.service.file.FileUploadService;
import com.elfak.eclassroom.service.lecture.LectureService;
import com.elfak.eclassroom.service.lecture.VideoService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Path(VideoResource.BASE_PATH)
@Tag(name = "Videos")
public class VideoResource extends BaseResource {

    static final String BASE_PATH = "lecture/{lectureId}/video";
    private LectureService lectureService;
    private VideoService videoService;
    private FileUploadService fileUploadService;

    @GET
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = VideoDto.class)
                    )
            ),
            description = "Fetches all videos from the database."
    )
    public Response getAll(@PathParam("lectureId") UUID lectureId, @QueryParam("ids") Set<UUID> ids) {
        return listResponse(videoService.getAllByIds(ids), VideoDto.class);
    }

    @GET
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VideoDto.class)
            ),
            description = "Fetches single video from the database."
    )
    @Path(ID_PATH)
    public Response getSingle(@PathParam("lectureId") UUID lectureId, @PathParam("id") UUID id) {
        if (!lectureService.getById(lectureId).isPresent()) return Response.noContent().build();
        Optional<Video> video = videoService.getById(id);
        if (video.isPresent()) return entityResponse(video.get(), VideoDto.class);
        return Response.noContent().build();
    }

    @POST
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VideoDto.class)
            ),
            description = "Creates a new video for a lecture."
    )
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(
            @PathParam("lectureId") UUID lectureId,
            @FormDataParam("durationInSeconds") long durationInSeconds,
            @FormDataParam("videoTitle") String videoTitle,
            @FormDataParam("thumbnail") InputStream thumbnailInputStream,
            @FormDataParam("thumbnail") FormDataContentDisposition thumbnailMeta,
            @FormDataParam("video") InputStream videoInputStream,
            @FormDataParam("video") FormDataContentDisposition videoMeta
    ) {
        Optional<Lecture> lecture = lectureService.getById(lectureId);

        if (!lecture.isPresent()) return Response.noContent().build();

        Optional<FileInfo> thumbnailInfo = Optional
                .ofNullable(fileUploadService.saveFile(thumbnailInputStream, thumbnailMeta, getServerFilePath()));

        if (!thumbnailInfo.isPresent()) return Response.serverError().build();

        Optional<FileInfo> videoInfo = Optional
                .ofNullable(fileUploadService.saveFile(videoInputStream, videoMeta, getServerFilePath()));

        if (!videoInfo.isPresent()) return Response.serverError().build();

        Video video = new Video();
        video.setDurationInSeconds(durationInSeconds);
        video.setTitle(videoTitle);
        video.setThumbnailUrl(thumbnailInfo.get().getFileUrl());
        video.setVideoUrl(videoInfo.get().getFileUrl());
        video.setLecture(lecture.get());

        Optional<Video> videoResult = videoService.createOrUpdate(video);

        if (!videoResult.isPresent()) return Response.noContent().build();

        return entityResponse(videoResult.get(), VideoDto.class);
    }

    @DELETE
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = VideoDto.class)
            ),
            description = "Deletes single video record."
    )
    @Path(ID_PATH)
    public Response delete(@PathParam("lectureId") UUID lectureId, @PathParam("id") UUID id) {
        if (!lectureService.getById(lectureId).isPresent()) return Response.noContent().build();
        Optional<Video> deleted = videoService.delete(id);
        if (deleted.isPresent()) return entityResponse(deleted, VideoDto.class);
        return Response.noContent().build();
    }

    @Inject
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @Inject
    public void setFileUploadService(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @Inject
    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }
}
