package com.elfak.eclassroom.data.lecture.repository;

import com.elfak.eclassroom.data.base.repository.BaseRepository;
import com.elfak.eclassroom.data.lecture.entity.VideoThreadMessage;

import java.util.UUID;

public interface ThreadMessageRepository extends BaseRepository<UUID, VideoThreadMessage> {
}
