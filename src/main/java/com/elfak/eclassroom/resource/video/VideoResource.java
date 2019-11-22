package com.elfak.eclassroom.resource.video;

import com.elfak.eclassroom.data.video.entity.Video;
import com.elfak.eclassroom.data.video.repository.VideoRepository;
import com.elfak.eclassroom.resource.base.impl.ServiceAwareResourceImpl;
import com.elfak.eclassroom.service.video.VideoService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/video")
public class VideoResource extends ServiceAwareResourceImpl<Long, Video, VideoRepository, VideoService> {

    @Inject
    protected VideoResource(VideoService service) {
        super(service);
    }
}
