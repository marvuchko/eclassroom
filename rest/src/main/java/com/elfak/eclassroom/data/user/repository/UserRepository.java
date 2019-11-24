package com.elfak.eclassroom.data.user.repository;

import com.elfak.eclassroom.data.base.repository.BaseRepository;
import com.elfak.eclassroom.data.user.entity.User;

import java.util.UUID;

public interface UserRepository extends BaseRepository<UUID, User> {
}
