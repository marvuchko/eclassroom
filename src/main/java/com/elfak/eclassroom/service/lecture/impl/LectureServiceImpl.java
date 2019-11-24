package com.elfak.eclassroom.service.lecture.impl;

import com.elfak.eclassroom.data.lecture.entity.Lecture;
import com.elfak.eclassroom.data.lecture.repository.LectureRepository;
import com.elfak.eclassroom.service.base.impl.RepositoryAwareServiceImpl;
import com.elfak.eclassroom.service.lecture.LectureService;

import javax.inject.Inject;
import java.util.UUID;

public class LectureServiceImpl extends RepositoryAwareServiceImpl<UUID, Lecture, LectureRepository> implements LectureService {

    @Inject
    public LectureServiceImpl(LectureRepository repository) {
        super(repository);
    }
}
