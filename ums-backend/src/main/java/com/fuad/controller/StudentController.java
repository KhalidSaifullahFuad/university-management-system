package com.fuad.controller;

import com.fuad.dto.StudentRequest;
import com.fuad.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/student")
public interface StudentController {
    @PostMapping("/")
    ResponseEntity<Student> create(@Valid @RequestBody StudentRequest studentRequest);

    @PutMapping("/")
    ResponseEntity<Student> update(@PathVariable UUID id, @Valid @RequestBody StudentRequest studentRequest);

    @GetMapping("/{id}")
    ResponseEntity<Student> getById(@PathVariable UUID id);

    @GetMapping("/")
    ResponseEntity<List<Student>> getAll();

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable UUID id);
}
