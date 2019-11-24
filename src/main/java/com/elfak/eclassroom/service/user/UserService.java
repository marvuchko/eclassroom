package com.elfak.eclassroom.service.user;

import com.elfak.eclassroom.data.user.entity.User;
import com.elfak.eclassroom.data.user.repository.UserRepository;
import com.elfak.eclassroom.service.base.RepositoryAwareService;

import java.util.UUID;

public interface UserService extends RepositoryAwareService<UUID, User, UserRepository> {
}
