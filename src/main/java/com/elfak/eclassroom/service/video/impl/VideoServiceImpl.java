package com.elfak.eclassroom.service.video.impl;

import com.elfak.eclassroom.data.video.entity.Video;
import com.elfak.eclassroom.data.video.repository.VideoRepository;
import com.elfak.eclassroom.service.base.impl.RepositoryAwareServiceImpl;
import com.elfak.eclassroom.service.video.VideoService;

import javax.inject.Inject;

public class VideoServiceImpl extends RepositoryAwareServiceImpl<Long, Video, VideoRepository> implements VideoService {

    @Inject
    public VideoServiceImpl(VideoRepository repository) {
        super(repository);
    }

}
