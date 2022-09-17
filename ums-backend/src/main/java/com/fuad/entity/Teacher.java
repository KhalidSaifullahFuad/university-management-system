package com.fuad.entity;

import com.fuad.enums.Gender;
import com.fuad.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "teachers")
public class Teacher {
    @Id
    private UUID id;
    private String name;
    private String password;
    private Gender gender;
    private String phoneNumber;
    private String email;
    private String teacherId;
    private String facultyCode;
    private Role role;
    private String image;
    private LocalDateTime createdAt;
}
