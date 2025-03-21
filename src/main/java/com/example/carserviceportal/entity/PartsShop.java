package com.example.carserviceportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class PartsShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parts_shop_id;

    @NotBlank(message = "Shop name is required")
    private String spare_parts_shop_name;

    @NotBlank(message = "Shop address is required")
    private String spare_part_shop_address;

    @NotNull(message = "Shop mobile number is required")
    @Positive(message = "Mobile number must be positive")
    private int spare_parts_shop_mobile;

    private boolean is_active = true; // Default value
    private boolean is_shop_active = true; // Default value

    @NotNull(message = "Spare part ID is required")
    private int spare_part_id;

    @NotNull(message = "Brand ID is required")
    private int brand_id;
}
