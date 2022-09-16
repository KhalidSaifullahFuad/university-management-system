package com.fuad.controller;

import com.fuad.entity.Teacher;
import com.fuad.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    
    private final TeacherService teacherService;

    // Store a new Teacher
    @PostMapping("/")
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.store(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }

    // Update a Teacher
    @PutMapping("/")
    public  ResponseEntity<Teacher> update(@RequestBody Teacher teacher) {
        Teacher updateTeacher = teacherService.update(teacher);
        return new ResponseEntity<>(updateTeacher, HttpStatus.ACCEPTED);
    }

    // Fetch a Teacher by id
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getById(@PathVariable UUID id) {
        Teacher teacher = teacherService.getById(id);
        return ResponseEntity.ok(teacher);
    }

    // Fetch all Teachers
    @GetMapping("/")
    public ResponseEntity<List<Teacher>> getAll() {
        List<Teacher> teachers = teacherService.getAll();
        return ResponseEntity.ok(teachers);
    }

    // Delete a Teacher
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        teacherService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
