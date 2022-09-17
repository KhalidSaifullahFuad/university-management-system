package com.fuad.controller;

import com.fuad.dto.TeacherRequest;
import com.fuad.entity.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping("/api/teacher")
public interface TeacherController {
    @PostMapping("/")
    ResponseEntity<Teacher> create(@Valid @RequestBody TeacherRequest teacherRequest);

    @PutMapping("/")
    ResponseEntity<Teacher> update(@PathVariable UUID id, @Valid @RequestBody TeacherRequest teacherRequest);

    @GetMapping("/{id}")
    ResponseEntity<Teacher> getById(@PathVariable UUID id);

    @GetMapping("/")
    ResponseEntity<List<Teacher>> getAll();

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable UUID id);
}
