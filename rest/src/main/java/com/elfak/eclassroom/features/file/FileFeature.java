package com.elfak.eclassroom.features.file;

import com.elfak.eclassroom.features.file.binder.FileBinder;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class FileFeature implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        context.register(MultiPartFeature.class);
        context.register(new FileBinder());
        return true;
    }
}
