package com.elfak.eclassroom.data.video.binder;

import com.elfak.eclassroom.data.video.repository.VideoRepository;
import com.elfak.eclassroom.data.video.repository.impl.VideoRepositoryImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class VideoRepositoryBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(VideoRepositoryImpl.class).to(VideoRepository.class);
    }
}
