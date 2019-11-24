package com.elfak.eclassroom.features.user.binder;

import com.elfak.eclassroom.service.user.UserService;
import com.elfak.eclassroom.service.user.impl.UserServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class UserServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(UserServiceImpl.class).to(UserService.class);
    }
}
