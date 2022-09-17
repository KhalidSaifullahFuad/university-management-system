package com.fuad.service;

import com.fuad.dto.TeacherRequest;
import com.fuad.entity.Teacher;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    Teacher store(TeacherRequest teacherRequest);

    Teacher getById(UUID id);

    List<Teacher> getAll();

    Teacher update(UUID id, TeacherRequest teacherRequest);

    void delete(UUID id);
}
