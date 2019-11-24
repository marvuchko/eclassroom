package com.elfak.eclassroom.data.user.repository.impl;

import com.elfak.eclassroom.data.base.repository.impl.BaseRepositoryImpl;
import com.elfak.eclassroom.data.user.entity.User;
import com.elfak.eclassroom.data.user.repository.UserRepository;

import java.util.UUID;

public class UserRepositoryImpl extends BaseRepositoryImpl<UUID, User> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }

}
