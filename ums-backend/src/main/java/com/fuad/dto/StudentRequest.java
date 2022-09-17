package com.fuad.dto;

import com.fuad.entity.EducationInformation;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class StudentRequest {
    @NotBlank(message = "Firstname is required")
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank(message = "Password is required")
    private String password;
    private String gender;
    @NotBlank(message = "Date of birth is required")
    private String dateOfBirth;
    private List<EducationInformation> educationInformationList;
//    @Size(min = 11, max = 13, message = "Phone number must be 11 characters")
    private List<String> phoneNumbers;
    @Email(message = "Invalid Email")
    private String email;
    private String address;
    @NotBlank(message = "Department is required")
    private String department;
    @NotBlank(message = "Batch is required")
    private String batch;
    private List<String> courseCodes;
    private String photoUrl;
}
