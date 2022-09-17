package com.fuad.service;

import com.fuad.entity.Student;
import com.fuad.entity.Teacher;
import com.fuad.enums.Role;
import com.fuad.exception.NotFoundException;
import com.fuad.repository.StudentRepository;
import com.fuad.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional
@Service
public class AuthService implements UserDetailsService {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws NotFoundException {
        Teacher teacher = teacherRepository.findByEmailOrTeacherId(username, username).orElse(null);
        if (teacher != null) {
            return User.builder()
                    .username(teacher.getEmail())
                    .password(teacher.getPassword())
                    .roles(Role.ROLE_TEACHER.name())
                    .build();
        }

        Student student = studentRepository.findByEmailOrStudentId(username, username).orElse(null);
        if (student != null) {
            return User.builder()
                    .username(student.getEmail())
                    .password(student.getPassword())
                    .roles(Role.ROLE_STUDENT.name())
                    .build();
        }

        throw new NotFoundException("User not found");
    }

}
