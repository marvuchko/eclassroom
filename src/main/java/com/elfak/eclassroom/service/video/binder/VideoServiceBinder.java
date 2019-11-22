package com.elfak.eclassroom.service.video.binder;

import com.elfak.eclassroom.service.video.VideoService;
import com.elfak.eclassroom.service.video.impl.VideoServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class VideoServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(VideoServiceImpl.class).to(VideoService.class);
    }
}
