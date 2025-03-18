package com.example.carserviceportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brand_id;

    @NotBlank(message = "Brand name is required")
    private String brand_name;

    @NotBlank(message = "Brand description is required")
    private String brand_desc;

    private boolean is_brand_active = true;
    private boolean is_deleted = false;
}
