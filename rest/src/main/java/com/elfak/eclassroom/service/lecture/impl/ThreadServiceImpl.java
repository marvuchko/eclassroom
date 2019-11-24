package com.elfak.eclassroom.service.lecture.impl;

import com.elfak.eclassroom.data.lecture.entity.VideoThread;
import com.elfak.eclassroom.data.lecture.repository.ThreadRepository;
import com.elfak.eclassroom.service.base.impl.RepositoryAwareServiceImpl;
import com.elfak.eclassroom.service.lecture.ThreadService;

import javax.inject.Inject;
import java.util.UUID;

public class ThreadServiceImpl extends RepositoryAwareServiceImpl<UUID, VideoThread, ThreadRepository> implements ThreadService {

    @Inject
    public ThreadServiceImpl(ThreadRepository repository) {
        super(repository);
    }
}
