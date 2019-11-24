package com.elfak.eclassroom.service.lecture.impl;

import com.elfak.eclassroom.data.lecture.entity.VideoThreadMessage;
import com.elfak.eclassroom.data.lecture.repository.ThreadMessageRepository;
import com.elfak.eclassroom.service.base.impl.RepositoryAwareServiceImpl;
import com.elfak.eclassroom.service.lecture.ThreadMessageService;

import javax.inject.Inject;
import java.util.UUID;

public class ThreadMessageServiceImpl extends RepositoryAwareServiceImpl<UUID, VideoThreadMessage, ThreadMessageRepository> implements ThreadMessageService {

    @Inject
    public ThreadMessageServiceImpl(ThreadMessageRepository repository) {
        super(repository);
    }
}
