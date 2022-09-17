package com.fuad.repository;

import com.fuad.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface TeacherRepository extends MongoRepository<Teacher, UUID> {
    Optional<Teacher> findByEmailOrTeacherId(String email, String teacherId);
}
