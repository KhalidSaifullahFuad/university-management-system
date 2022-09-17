package com.fuad.controller;

import com.fuad.entity.Department;
import com.fuad.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class DepartmentControllerImpl implements DepartmentController {
    
    private final DepartmentService departmentService;

    @Override
    public ResponseEntity<Department> create(Department department) {
        Department newDepartment = departmentService.store(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Department> update(UUID id, Department department) {
        Department updateDepartment = departmentService.update(id, department);
        return new ResponseEntity<>(updateDepartment, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Department> getById(UUID id) {
        Department department = departmentService.getById(id);
        return ResponseEntity.ok(department);
    }

    @Override
    public ResponseEntity<List<Department>> getAll() {
        List<Department> departments = departmentService.getAll();
        return ResponseEntity.ok(departments);
    }

    @Override
    public ResponseEntity<?> delete(UUID id) {
        departmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
