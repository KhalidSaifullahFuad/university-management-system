package com.fuad.service;

import com.fuad.entity.Department;
import com.fuad.exception.DuplicateEntryException;
import com.fuad.exception.NotFoundException;
import com.fuad.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department store(Department department) {
        departmentRepository.findByDepartmentNameOrDepartmentCode(department.getDepartmentName(), department.getDepartmentCode())
                .ifPresent(entry -> {
                    throw new DuplicateEntryException("Department already exists");
                });

        department.setId(UUID.randomUUID());   // Generate a random id, since mongoDB doesn't generate it automatically
        return departmentRepository.save(department);
    }

    public Department update(UUID id, Department department) {
        departmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Department not found"));
        return departmentRepository.save(department);
    }

    public Department getById(UUID id) {
        return departmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Department not found"));
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public void delete(UUID id) {
        departmentRepository.deleteById(id);
    }
}
