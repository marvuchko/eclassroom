package com.elfak.eclassroom.data.lecture.repository.impl;

import com.elfak.eclassroom.data.base.repository.impl.BaseRepositoryImpl;
import com.elfak.eclassroom.data.lecture.entity.Video;
import com.elfak.eclassroom.data.lecture.repository.VideoRepository;

import java.util.UUID;

public class VideoRepositoryImpl extends BaseRepositoryImpl<UUID, Video> implements VideoRepository {

    public VideoRepositoryImpl() {
        super(Video.class);
    }

}
