package com.fuad.service;

import com.fuad.entity.Teacher;
import com.fuad.exception.NotFoundException;
import com.fuad.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository TeacherRepository;

    @Override
    public Teacher store(Teacher teacher) {
        teacher.setId(UUID.randomUUID());
        return TeacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        TeacherRepository.findById(teacher.getId()).orElseThrow(() -> new NotFoundException("Teacher not found"));
        return TeacherRepository.save(teacher);
    }

    @Override
    public Teacher getById(UUID id) {
        return TeacherRepository.findById(id).orElseThrow(() -> new NotFoundException("Teacher not found"));
    }

    @Override
    public List<Teacher> getAll() {
        return TeacherRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        TeacherRepository.deleteById(id);
    }
}
