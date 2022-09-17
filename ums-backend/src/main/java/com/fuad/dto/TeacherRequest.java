package com.fuad.dto;

import com.fuad.enums.Gender;
import com.fuad.enums.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class TeacherRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Gender is required")
    private String gender;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @Email(message = "Email is required")
    private String email;
    private String image;
}
