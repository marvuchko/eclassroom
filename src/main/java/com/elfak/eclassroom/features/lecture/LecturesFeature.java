package com.elfak.eclassroom.features.lecture;

import com.elfak.eclassroom.features.lecture.binder.LecturesRepositoryBinder;
import com.elfak.eclassroom.features.lecture.binder.LecturesServiceBinder;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class LecturesFeature implements Feature {
    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(new LecturesRepositoryBinder());
        featureContext.register(new LecturesServiceBinder());
        return true;
    }
}
