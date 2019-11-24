package com.elfak.eclassroom.data.lecture.repository;

import com.elfak.eclassroom.data.base.repository.BaseRepository;
import com.elfak.eclassroom.data.lecture.entity.Lecture;

import java.util.UUID;

public interface LectureRepository extends BaseRepository<UUID, Lecture> {
}
