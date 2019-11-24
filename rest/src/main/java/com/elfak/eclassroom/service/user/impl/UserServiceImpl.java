package com.elfak.eclassroom.service.user.impl;

import com.elfak.eclassroom.data.user.entity.User;
import com.elfak.eclassroom.data.user.repository.UserRepository;
import com.elfak.eclassroom.service.base.impl.RepositoryAwareServiceImpl;
import com.elfak.eclassroom.service.user.UserService;

import javax.inject.Inject;
import java.util.UUID;

public class UserServiceImpl extends RepositoryAwareServiceImpl<UUID, User, UserRepository> implements UserService {

    @Inject
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
