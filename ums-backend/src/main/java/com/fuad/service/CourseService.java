package com.fuad.service;

import com.fuad.entity.Course;
import com.fuad.exception.DuplicateEntryException;
import com.fuad.exception.NotFoundException;
import com.fuad.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public Course store(Course course) {
        courseRepository.findByCourseCode(course.getCourseCode())
                .ifPresent(entry -> {
                    throw new DuplicateEntryException("Course already exists");
                });

        course.setId(UUID.randomUUID());   // Generate a random id, since mongoDB doesn't generate it automatically
        return courseRepository.save(course);
    }

    public Course update(UUID id, Course course) {
        courseRepository.findById(id).orElseThrow(() -> new NotFoundException("Course not found"));
        return courseRepository.save(course);
    }

    public Course getById(UUID id) {
        return courseRepository.findById(id).orElseThrow(() -> new NotFoundException("Course not found"));
    }

    public Course getByCourseCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode).orElseThrow(() -> new NotFoundException("Course not found"));
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public void delete(UUID id) {
        courseRepository.deleteById(id);
    }

    protected List<Course> getCourseList(List<String> courseCodeList) {
        List<Course> courseList = new ArrayList<>();
        for (String courseCode : courseCodeList) {
            Course course = courseRepository.findByCourseCode(courseCode).orElseThrow(() -> new NotFoundException("Course not found"));
            courseList.add(course);
        }
        return courseList;
    }
}
