package com.fuad.controller;

import com.fuad.entity.Student;
import com.fuad.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    // Store a new student
    @PostMapping("/")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student newStudent = studentService.store(student);
        return ResponseEntity.ok(newStudent);
    }

    // Update a student
    @PutMapping("/")
    public  ResponseEntity<Student> update(@RequestBody Student student) {
        Student updateStudent = studentService.update(student);
        return ResponseEntity.ok(updateStudent);
    }

    // Fetch a student by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable UUID id) {
        Student student = studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    // Fetch all students
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

}
