package com.fuad.controller;

import com.fuad.entity.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping("/api/course")
public interface CourseController {
    @PostMapping("/")
    ResponseEntity<Course> create(@Valid @RequestBody Course course);

    @PutMapping("/")
    ResponseEntity<Course> update(@PathVariable UUID id, @Valid @RequestBody Course course);

    @GetMapping("/{id}")
    ResponseEntity<Course> getById(@PathVariable UUID id);

    @GetMapping("/")
    ResponseEntity<List<Course>> getAll();

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable UUID id);
}
