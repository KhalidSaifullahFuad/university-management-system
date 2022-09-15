package com.fuad.service;

import com.fuad.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    Student store(Student student);

    Student getById(UUID id);

    List<Student> getAll();

    Student update(Student student);

    void delete(UUID id);
}
