package com.example.carserviceportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Data
public class SparePartsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spare_part_id;

    @NotBlank(message = "Spare part name is required")
    private String spare_part_name;

    @NotBlank(message = "Spare part description is required")
    private String spare_part_description;

    @NotNull(message = "Spare part category ID is required")
    private int spare_part_category_id;

    @NotNull(message = "Spare part brand ID is required")
    private int spare_parts_brand;

    @NotNull(message = "Spare part price is required")
    @Positive(message = "Price must be positive")
    private double spare_part_price;

    @NotNull(message = "Spare part quantity is required")
    @PositiveOrZero(message = "Quantity must be positive or zero")
    private int spare_part_qty;

    private boolean is_spare_part_active = true; // Default value
    private boolean is_active = true;
}
