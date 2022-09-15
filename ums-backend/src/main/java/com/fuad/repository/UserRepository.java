package com.fuad.repository;

import com.fuad.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
}
