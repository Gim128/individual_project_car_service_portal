package com.example.carserviceportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;

    @NotBlank(message = "Categoryname is required")
    private String category_name;

    @NotBlank(message = "Category description is required")
    private String category_description;

    private boolean is_active = true;
    private boolean is_deleted = false;
}
