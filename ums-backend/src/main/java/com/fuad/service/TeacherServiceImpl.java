package com.fuad.service;

import com.fuad.dto.TeacherRequest;
import com.fuad.entity.Teacher;
import com.fuad.enums.Gender;
import com.fuad.enums.Role;
import com.fuad.exception.NotFoundException;
import com.fuad.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository TeacherRepository;

    @Override
    public Teacher store(TeacherRequest teacherRequest) {
        Teacher teacher = dtoToEntity(teacherRequest);
        teacher.setId(UUID.randomUUID());
        return TeacherRepository.save(teacher);
    }

    @Override
    public Teacher update(UUID id, TeacherRequest teacherRequest) {
        TeacherRepository.findById(id).orElseThrow(() -> new NotFoundException("Teacher not found"));
        return TeacherRepository.save(dtoToEntity(teacherRequest));
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

    private Teacher dtoToEntity(TeacherRequest teacherRequest) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherRequest, teacher);
        teacher.setGender(Gender.get(teacherRequest.getGender()));
        teacher.setRole(Role.TEACHER);
        teacher.setCreatedAt(LocalDateTime.now());
        return teacher;
    }
}
