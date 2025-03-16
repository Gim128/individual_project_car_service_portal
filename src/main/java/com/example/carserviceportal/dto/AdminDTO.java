package com.example.carserviceportal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdminDTO {
    @Getter
    @Setter
    @NotBlank(message = "Admin name is required")
    private String admin_name;

    @Getter
    @Setter
    @NotBlank(message = "Admin email is requied")
    @Email(message = "Invalid email format")
    private String admin_Email;

    @Getter
    @Setter
    @NotBlank(message = "Amin passowrd is required")
    @Size(message = "Password must be at least 6 characters")
    private String admin_Password;

    private boolean is_active = true;
    private boolean is_deleted = false;




}
