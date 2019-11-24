package com.elfak.eclassroom.features.lecture.binder;

import com.elfak.eclassroom.service.lecture.LectureService;
import com.elfak.eclassroom.service.lecture.ThreadMessageService;
import com.elfak.eclassroom.service.lecture.ThreadService;
import com.elfak.eclassroom.service.lecture.VideoService;
import com.elfak.eclassroom.service.lecture.impl.LectureServiceImpl;
import com.elfak.eclassroom.service.lecture.impl.ThreadMessageServiceImpl;
import com.elfak.eclassroom.service.lecture.impl.ThreadServiceImpl;
import com.elfak.eclassroom.service.lecture.impl.VideoServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class LecturesServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(LectureServiceImpl.class).to(LectureService.class);
        bind(VideoServiceImpl.class).to(VideoService.class);
        bind(ThreadServiceImpl.class).to(ThreadService.class);
        bind(ThreadMessageServiceImpl.class).to(ThreadMessageService.class);
    }
}
