package com.example.carserviceportal.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank(message = "First name is required")
    private String first_name;

    @NotBlank(message = "last name is required")
    private String last_name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "password must be at 6 characters")
    private String Password;

    @NotNull(message = "User type is required")
    private int user_type;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Mobile number is required")
    @Positive(message = "Mobile number must be positive")
    private int mobile;
}
