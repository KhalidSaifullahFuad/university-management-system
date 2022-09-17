package com.fuad.repository;

import com.fuad.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface DepartmentRepository extends MongoRepository<Department, UUID> {
    Optional<Department> findByDepartmentNameOrDepartmentCode(String departmentName, String departmentCode);
}
