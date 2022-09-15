package com.fuad.service;

import com.fuad.entity.User;
import com.fuad.exception.NotFoundException;
import com.fuad.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository UserRepository;

    @Override
    public User store(User user) {
        user.setId(UUID.randomUUID());
        return UserRepository.save(user);
    }

    @Override
    public User update(User user) {
        UserRepository.findById(user.getId()).orElseThrow(() -> new NotFoundException("User not found"));
        return UserRepository.save(user);
    }

    @Override
    public User getById(UUID id) {
        return UserRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public List<User> getAll() {
        return UserRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        UserRepository.deleteById(id);
    }
}
