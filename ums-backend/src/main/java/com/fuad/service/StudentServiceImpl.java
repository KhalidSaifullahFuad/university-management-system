package com.fuad.service;

import com.fuad.entity.Student;
import com.fuad.exception.NotFoundException;
import com.fuad.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student store(Student student) {
        student.setId(UUID.randomUUID());
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        studentRepository.findById(student.getId()).orElseThrow(() -> new NotFoundException("Student not found"));
        return studentRepository.save(student);
    }

    @Override
    public Student getById(UUID id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }
}
