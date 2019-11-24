package com.elfak.eclassroom.features.lecture.binder;

import com.elfak.eclassroom.data.lecture.repository.LectureRepository;
import com.elfak.eclassroom.data.lecture.repository.ThreadMessageRepository;
import com.elfak.eclassroom.data.lecture.repository.ThreadRepository;
import com.elfak.eclassroom.data.lecture.repository.VideoRepository;
import com.elfak.eclassroom.data.lecture.repository.impl.LectureRepositoryImpl;
import com.elfak.eclassroom.data.lecture.repository.impl.ThreadMessageRepositoryImpl;
import com.elfak.eclassroom.data.lecture.repository.impl.ThreadRepositoryImpl;
import com.elfak.eclassroom.data.lecture.repository.impl.VideoRepositoryImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

public class LecturesRepositoryBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(VideoRepositoryImpl.class).to(VideoRepository.class);
        bind(LectureRepositoryImpl.class).to(LectureRepository.class);
        bind(ThreadRepositoryImpl.class).to(ThreadRepository.class);
        bind(ThreadMessageRepositoryImpl.class).to(ThreadMessageRepository.class);
    }
}
