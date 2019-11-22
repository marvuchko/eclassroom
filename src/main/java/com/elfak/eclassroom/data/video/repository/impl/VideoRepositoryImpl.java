package com.elfak.eclassroom.data.video.repository.impl;

import com.elfak.eclassroom.data.base.repository.impl.BaseRepositoryImpl;
import com.elfak.eclassroom.data.video.entity.Video;
import com.elfak.eclassroom.data.video.repository.VideoRepository;

public class VideoRepositoryImpl extends BaseRepositoryImpl<Long, Video> implements VideoRepository {

    public VideoRepositoryImpl() {
        super(Video.class);
    }

}
