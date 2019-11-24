package com.elfak.eclassroom.service.lecture;

import com.elfak.eclassroom.data.lecture.entity.Lecture;
import com.elfak.eclassroom.data.lecture.repository.LectureRepository;
import com.elfak.eclassroom.service.base.RepositoryAwareService;

import java.util.UUID;

public interface LectureService extends RepositoryAwareService<UUID, Lecture, LectureRepository> {
}
