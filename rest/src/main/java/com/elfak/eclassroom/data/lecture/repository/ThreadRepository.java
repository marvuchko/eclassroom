package com.elfak.eclassroom.data.lecture.repository;

import com.elfak.eclassroom.data.base.repository.BaseRepository;
import com.elfak.eclassroom.data.lecture.entity.VideoThread;

import java.util.UUID;

public interface ThreadRepository extends BaseRepository<UUID, VideoThread> {
}
