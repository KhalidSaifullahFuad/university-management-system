package com.fuad.service;

import com.fuad.entity.Teacher;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    Teacher store(Teacher teacher);

    Teacher getById(UUID id);

    List<Teacher> getAll();

    Teacher update(Teacher teacher);

    void delete(UUID id);
}
