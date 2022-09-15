package com.fuad.entity;


import com.fuad.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "students")
public class Student {
    @Id
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private Gender gender;
    private String  dateOfBirth;
    private List<EducationInformation> educationInformation;
    private List<String> phoneNumbers;
    private String email;
    private String address;
    private Department department;
    private String currentSemester;
    private String batch;
    private String studentId;
    private Integer totalCredit;
    private Integer completedCredits;
    private Double cgpa;
    private String image;
    private LocalDateTime createdAt;
}
