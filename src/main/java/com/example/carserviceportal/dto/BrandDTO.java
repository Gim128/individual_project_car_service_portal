package com.example.carserviceportal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BrandDTO {
    @NotBlank(message = "Brand name is required")
    private String brand_name;

    @NotBlank(message = "Brand description is required")
    private String brand_desc;
}
