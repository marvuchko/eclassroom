package com.elfak.eclassroom.features.user;

import com.elfak.eclassroom.features.user.binder.UserRepositoryBinder;
import com.elfak.eclassroom.features.user.binder.UserServiceBinder;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class UserFeature implements Feature {
    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(new UserRepositoryBinder());
        featureContext.register(new UserServiceBinder());
        return true;
    }
}
