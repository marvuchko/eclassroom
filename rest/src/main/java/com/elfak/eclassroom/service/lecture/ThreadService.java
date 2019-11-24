package com.elfak.eclassroom.service.lecture;

import com.elfak.eclassroom.data.lecture.entity.VideoThread;
import com.elfak.eclassroom.data.lecture.repository.ThreadRepository;
import com.elfak.eclassroom.service.base.RepositoryAwareService;

import java.util.UUID;

public interface ThreadService extends RepositoryAwareService<UUID, VideoThread, ThreadRepository> {
}
