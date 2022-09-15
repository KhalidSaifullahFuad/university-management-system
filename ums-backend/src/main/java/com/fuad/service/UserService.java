package com.fuad.service;

import com.fuad.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User store(User user);

    User getById(UUID id);

    List<User> getAll();

    User update(User user);

    void delete(UUID id);
}
