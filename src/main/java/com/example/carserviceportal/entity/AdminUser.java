package com.example.carserviceportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;

    @NotBlank(message = "Admin name is required")
    private String admin_name;

    @NotBlank(message = "admin email is required")
    @Email(message = "Invalid email format")
    private String admin_email;

    @NotBlank(message = "Admin password is required")
    @Size(min = 6, message = "password must be at least 6 characters")
    private String admin_password;

    private boolean is_active = true;
    private boolean is_deleted = false;


}
