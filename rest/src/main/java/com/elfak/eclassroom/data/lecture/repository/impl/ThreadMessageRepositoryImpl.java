package com.elfak.eclassroom.data.lecture.repository.impl;

import com.elfak.eclassroom.data.base.repository.impl.BaseRepositoryImpl;
import com.elfak.eclassroom.data.lecture.entity.VideoThreadMessage;
import com.elfak.eclassroom.data.lecture.repository.ThreadMessageRepository;

import java.util.UUID;

public class ThreadMessageRepositoryImpl extends BaseRepositoryImpl<UUID, VideoThreadMessage> implements ThreadMessageRepository {

    public ThreadMessageRepositoryImpl() {
        super(VideoThreadMessage.class);
    }

}
