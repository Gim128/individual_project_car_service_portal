package com.example.carserviceportal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {
    @NotBlank(message = "Category name is required")
    private String category_name;

    @NotBlank(message = "Category description is required")
    private String category_description;
}
