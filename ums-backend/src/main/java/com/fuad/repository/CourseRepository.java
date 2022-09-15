package com.fuad.repository;

import com.fuad.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CourseRepository extends MongoRepository<Course, UUID> {
}