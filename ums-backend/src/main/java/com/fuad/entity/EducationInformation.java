package com.fuad.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "education_informations")
public class EducationInformation {
    @Id
    private Long id;
    private String degreeName;
    private String instituteName;
    private String result;
    private Double cgpa;
    private String passingYear;
}
