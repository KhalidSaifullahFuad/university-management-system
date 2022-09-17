package com.fuad.service;

import com.fuad.dto.StudentRequest;
import com.fuad.entity.Student;
import com.fuad.enums.Gender;
import com.fuad.exception.DuplicateEntryException;
import com.fuad.exception.NotFoundException;
import com.fuad.repository.DepartmentRepository;
import com.fuad.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final CourseService courseService;

    @Override
    public Student store(StudentRequest studentRequest) {
        Student student = dtoToEntity(studentRequest);
        studentRepository.findByEmailOrStudentId(student.getEmail(), student.getStudentId())
                .ifPresent(entry -> {
                    throw new DuplicateEntryException("Student already exists");
                });

        student.setId(UUID.randomUUID());   // Generate a random id, since mongoDB doesn't generate it automatically
        return studentRepository.save(student);
    }

    @Override
    public Student update(UUID id, StudentRequest studentRequest) {
        studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not found"));
        Student student = dtoToEntity(studentRequest);
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

    public String addCourse(UUID studentId, String courseCode) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("Student not found"));
        student.getCourseList().add(courseService.getByCourseCode(courseCode));
        studentRepository.save(student);
        return "Course added successfully";
    }

    protected Student dtoToEntity(StudentRequest studentRequest) {
        Student student = new Student();
        BeanUtils.copyProperties(studentRequest, student); // copy values from studentRequest to student
        student.setGender(Gender.get(studentRequest.getGender()));
        student.setDepartment(departmentRepository.findByDepartmentNameOrDepartmentCode(studentRequest.getDepartment(), studentRequest.getDepartment())
                .orElseThrow(() -> new NotFoundException("Department not found")));
        student.setCourseList(courseService.getCourseList(studentRequest.getCourseCodes()));
        student.setCreatedAt(LocalDateTime.now());
        return student;
    }

}
