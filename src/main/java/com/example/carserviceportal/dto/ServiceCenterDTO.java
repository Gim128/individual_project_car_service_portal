package com.example.carserviceportal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ServiceCenterDTO {
    @NotBlank(message = "Service center name is required")
    private String service_center_name;

    @NotNull(message = "Service center mobile is required")
    @Positive(message = "Mobile number must be positive")
    private int service_center_mobile;

    @NotBlank(message = "Service center email is required")
    @Email(message = "Invalid email format")
    private String service_center_email;

    @NotBlank(message = "Service center location is required")
    private String service_center_location;
}
