package com.fuad.controller;

import com.fuad.entity.Course;
import com.fuad.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class CourseControllerImpl implements CourseController {
    
    private final CourseService courseService;

    @Override
    public ResponseEntity<Course> create(Course course) {
        Course newCourse = courseService.store(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Course> update(UUID id, Course course) {
        Course updateCourse = courseService.update(id, course);
        return new ResponseEntity<>(updateCourse, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Course> getById(UUID id) {
        Course course = courseService.getById(id);
        return ResponseEntity.ok(course);
    }

    @Override
    public ResponseEntity<List<Course>> getAll() {
        List<Course> courses = courseService.getAll();
        return ResponseEntity.ok(courses);
    }

    @Override
    public ResponseEntity<?> delete(UUID id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
