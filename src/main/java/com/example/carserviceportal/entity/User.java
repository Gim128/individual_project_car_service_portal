package com.example.carserviceportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @NotBlank(message = "First name is required")
    private String first_name;

    @NotBlank(message = "Last name is required")
    private String last_name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotNull(message = "User type is required")
    private int user_type;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Mobile number is required")
    @Positive(message = "mobile number must be positive")
    private int mobile;

    @NotBlank(message = "Role is required")
    private String role;

    private boolean is_active = true;


}
