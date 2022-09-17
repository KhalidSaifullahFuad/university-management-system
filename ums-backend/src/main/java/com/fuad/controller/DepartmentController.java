package com.fuad.controller;

import com.fuad.entity.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RequestMapping("/api/department")
public interface DepartmentController {
    @PostMapping("/")
    ResponseEntity<Department> create(@Valid @RequestBody Department department);

    @PutMapping("/")
    ResponseEntity<Department> update(@PathVariable UUID id, @Valid @RequestBody Department department);

    @GetMapping("/{id}")
    ResponseEntity<Department> getById(@PathVariable UUID id);

    @GetMapping("/")
    ResponseEntity<List<Department>> getAll();

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable UUID id);
}
