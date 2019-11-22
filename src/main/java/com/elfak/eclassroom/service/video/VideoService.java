package com.elfak.eclassroom.service.video;

import com.elfak.eclassroom.data.video.entity.Video;
import com.elfak.eclassroom.data.video.repository.VideoRepository;
import com.elfak.eclassroom.service.base.RepositoryAwareService;

public interface VideoService extends RepositoryAwareService<Long, Video, VideoRepository> {
}
