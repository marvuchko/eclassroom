package com.elfak.eclassroom.resource.lecture;

import com.elfak.eclassroom.data.lecture.entity.Lecture;
import com.elfak.eclassroom.data.lecture.entity.Video;
import com.elfak.eclassroom.data.user.entity.User;
import com.elfak.eclassroom.dto.file.FileInfo;
import com.elfak.eclassroom.dto.lecture.LectureDto;
import com.elfak.eclassroom.resource.base.BaseResource;
import com.elfak.eclassroom.service.file.FileUploadService;
import com.elfak.eclassroom.service.lecture.LectureService;
import com.elfak.eclassroom.service.user.UserService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static java.util.Collections.singleton;

@Path(LectureResource.BASE_PATH)
@Tag(name = "Lectures")
public class LectureResource extends BaseResource {

    static final String BASE_PATH = "/lecture";
    @Context
    private UriInfo uri;
    private LectureService lectureService;
    private UserService userService;
    private FileUploadService fileUploadService;

    @GET
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = LectureDto.class)
                    )
            ),
            description = "Fetches all Lectures from the database."
    )
    public Response getAll(@QueryParam("ids") Set<UUID> ids) {
        return listResponse(lectureService.getAllByIds(ids), LectureDto.class);
    }

    @GET
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = LectureDto.class)
            ),
            description = "Fetches single Lecture from the database."
    )
    @Path(ID_PATH)
    public Response getSingle(@PathParam("id") UUID id) {
        Optional<Lecture> lecture = lectureService.getById(id);
        if (lecture.isPresent()) return entityResponse(lecture.get(), LectureDto.class);
        return Response.noContent().build();
    }

    @DELETE
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = LectureDto.class)
            ),
            description = "Fetches single Lecture from the database."
    )
    @Path(ID_PATH)
    public Response delete(@PathParam("id") UUID id) {
        Optional<Lecture> lecture = lectureService.delete(id);
        if (lecture.isPresent()) return entityResponse(lecture.get(), LectureDto.class);
        return Response.noContent().build();
    }

    @POST
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = LectureDto.class)
            ),
            description = "Creates a new lecture with a video."
    )
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(
            @FormDataParam("fullName") String fullName,
            @FormDataParam("email") String email,
            @FormDataParam("title") String title,
            @FormDataParam("description") String description,
            @FormDataParam("durationInSeconds") long durationInSeconds,
            @FormDataParam("videoTitle") String videoTitle,
            @FormDataParam("thumbnail") InputStream thumbnailInputStream,
            @FormDataParam("thumbnail") FormDataContentDisposition thumbnailMeta,
            @FormDataParam("video") InputStream videoInputStream,
            @FormDataParam("video") FormDataContentDisposition videoMeta
    ) {
        Optional<FileInfo> thumbnailInfo = Optional
                .ofNullable(fileUploadService.saveFile(thumbnailInputStream, thumbnailMeta, getServerPath(uri)));

        if (!thumbnailInfo.isPresent()) return Response.serverError().build();

        Optional<FileInfo> videoInfo = Optional
                .ofNullable(fileUploadService.saveFile(videoInputStream, videoMeta, getServerPath(uri)));

        if (!videoInfo.isPresent()) return Response.serverError().build();

        User tutor = new User();
        tutor.setFullName(fullName);
        tutor.setEmail(email);

        Lecture lecture = new Lecture();
        lecture.setTitle(title);
        lecture.setDescription(description);
        lecture.setTutor(tutor);

        tutor.setLectures(singleton(lecture));

        Video video = new Video();
        video.setDurationInSeconds(durationInSeconds);
        video.setTitle(videoTitle);
        video.setThumbnailUrl(thumbnailInfo.get().getFileUrl());
        video.setVideoUrl(videoInfo.get().getFileUrl());
        video.setLecture(lecture);

        lecture.setVideos(singleton(video));

        Optional<User> tutorResult = userService.createOrUpdate(tutor);

        if (!tutorResult.isPresent()) return Response.noContent().build();

        return entityResponse(lecture, LectureDto.class);
    }

    @Inject
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Inject
    public void setFileUploadService(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }
}
