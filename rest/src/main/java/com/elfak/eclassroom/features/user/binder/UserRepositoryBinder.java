package com.elfak.eclassroom.features.user.binder;

import com.elfak.eclassroom.data.user.repository.UserRepository;
import com.elfak.eclassroom.data.user.repository.impl.UserRepositoryImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class UserRepositoryBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(UserRepositoryImpl.class).to(UserRepository.class);
    }
}
