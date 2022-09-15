package com.fuad.repository;

import com.fuad.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface StudentRepository extends MongoRepository<Student, UUID> {
}
