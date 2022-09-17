package com.fuad.service;

import com.fuad.dto.StudentRequest;
import com.fuad.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    Student store(StudentRequest studentRequest);

    Student update(UUID id, StudentRequest studentRequest);

    Student getById(UUID id);

    List<Student> getAll();

    void delete(UUID id);
}
