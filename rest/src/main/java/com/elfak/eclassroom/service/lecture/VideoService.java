package com.elfak.eclassroom.service.lecture;

import com.elfak.eclassroom.data.lecture.entity.Video;
import com.elfak.eclassroom.data.lecture.repository.VideoRepository;
import com.elfak.eclassroom.service.base.RepositoryAwareService;

import java.util.UUID;

public interface VideoService extends RepositoryAwareService<UUID, Video, VideoRepository> {
}
