package com.elfak.eclassroom.data.lecture.repository.impl;

import com.elfak.eclassroom.data.base.repository.impl.BaseRepositoryImpl;
import com.elfak.eclassroom.data.lecture.entity.VideoThread;
import com.elfak.eclassroom.data.lecture.repository.ThreadRepository;

import java.util.UUID;

public class ThreadRepositoryImpl extends BaseRepositoryImpl<UUID, VideoThread> implements ThreadRepository {

    public ThreadRepositoryImpl() {
        super(VideoThread.class);
    }

}
