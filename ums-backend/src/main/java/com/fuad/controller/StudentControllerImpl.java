package com.fuad.controller;

import com.fuad.dto.StudentRequest;
import com.fuad.entity.Student;
import com.fuad.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    // Store a new student
    @Override
    public ResponseEntity<Student> create(StudentRequest student) {
        Student newStudent = studentService.store(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    // Update a student
    @Override
    public ResponseEntity<Student> update(UUID id, StudentRequest student) {
        Student updateStudent = studentService.update(id, student);
        return new ResponseEntity<>(updateStudent, HttpStatus.ACCEPTED);
    }

    // Fetch a student by id
    @Override
    public ResponseEntity<Student> getById(UUID id) {
        Student student = studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    // Fetch all students
    @Override
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    // Delete a student
    @Override
    public ResponseEntity<?> delete(UUID id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
