package com.fuad.controller;

import com.fuad.dto.TeacherRequest;
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
public class TeacherControllerImpl implements TeacherController {
    
    private final TeacherService teacherService;

    // Store a new Teacher
    @Override
    public ResponseEntity<Teacher> create(TeacherRequest teacherRequest) {
        Teacher newTeacher = teacherService.store(teacherRequest);
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }

    // Update a Teacher
    @Override
    public ResponseEntity<Teacher> update(UUID id, TeacherRequest teacherRequest) {
        Teacher updateTeacher = teacherService.update(id, teacherRequest);
        return new ResponseEntity<>(updateTeacher, HttpStatus.ACCEPTED);
    }

    // Fetch a Teacher by id
    @Override
    public ResponseEntity<Teacher> getById(UUID id) {
        Teacher teacher = teacherService.getById(id);
        return ResponseEntity.ok(teacher);
    }

    // Fetch all Teachers
    @Override
    public ResponseEntity<List<Teacher>> getAll() {
        List<Teacher> teachers = teacherService.getAll();
        return ResponseEntity.ok(teachers);
    }

    // Delete a Teacher
    @Override
    public ResponseEntity<?> delete(UUID id) {
        teacherService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
