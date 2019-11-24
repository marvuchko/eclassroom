package com.elfak.eclassroom.data.lecture.repository;

import com.elfak.eclassroom.data.base.repository.BaseRepository;
import com.elfak.eclassroom.data.lecture.entity.Video;

import java.util.UUID;

public interface VideoRepository extends BaseRepository<UUID, Video> {
}
