package com.elfak.eclassroom.features.video;

import com.elfak.eclassroom.data.video.binder.VideoRepositoryBinder;
import com.elfak.eclassroom.service.video.binder.VideoServiceBinder;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class VideoFeature implements Feature {
    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(new VideoRepositoryBinder());
        featureContext.register(new VideoServiceBinder());
        return true;
    }
}
