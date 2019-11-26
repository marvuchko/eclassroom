package com.elfak.eclassroom.features.base;

import com.elfak.eclassroom.filter.cors.CorsFilter;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFeature implements Feature {
    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(new CorsFilter());
        return true;
    }
}
