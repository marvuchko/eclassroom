package com.elfak.eclassroom.service.lecture.impl;

import com.elfak.eclassroom.data.lecture.entity.Video;
import com.elfak.eclassroom.data.lecture.repository.VideoRepository;
import com.elfak.eclassroom.service.base.impl.RepositoryAwareServiceImpl;
import com.elfak.eclassroom.service.lecture.VideoService;

import javax.inject.Inject;
import java.util.UUID;

public class VideoServiceImpl extends RepositoryAwareServiceImpl<UUID, Video, VideoRepository> implements VideoService {

    @Inject
    public VideoServiceImpl(VideoRepository repository) {
        super(repository);
    }

}
