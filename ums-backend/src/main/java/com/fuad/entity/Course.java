package com.fuad.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "courses")
public class Course {
    @Id
    private UUID id;
    private String courseName;
    private String courseCode;
    private String description;
    private Integer credit;
    private String department;
    private String semester;
    private String teacherId;
    private String teacherName;
    private String facultyCode;
}
