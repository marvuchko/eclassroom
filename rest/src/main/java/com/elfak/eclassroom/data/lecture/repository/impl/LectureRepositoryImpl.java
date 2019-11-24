package com.elfak.eclassroom.data.lecture.repository.impl;

import com.elfak.eclassroom.data.base.repository.impl.BaseRepositoryImpl;
import com.elfak.eclassroom.data.lecture.entity.Lecture;
import com.elfak.eclassroom.data.lecture.repository.LectureRepository;

import java.util.UUID;

public class LectureRepositoryImpl extends BaseRepositoryImpl<UUID, Lecture> implements LectureRepository {

    public LectureRepositoryImpl() {
        super(Lecture.class);
    }

}
