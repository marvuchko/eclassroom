package com.elfak.eclassroom.service.lecture;

import com.elfak.eclassroom.data.lecture.entity.VideoThreadMessage;
import com.elfak.eclassroom.data.lecture.repository.ThreadMessageRepository;
import com.elfak.eclassroom.service.base.RepositoryAwareService;

import java.util.UUID;

public interface ThreadMessageService extends RepositoryAwareService<UUID, VideoThreadMessage, ThreadMessageRepository> {
}
