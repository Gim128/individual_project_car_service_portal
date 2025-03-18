package com.example.carserviceportal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PartsShopDTO {
    @NotBlank(message = "Shop name is required")
    private String spare_parts_shop_name;

    @NotBlank(message = "Shop address is required")
    private String spare_part_shop_address;

    @NotNull(message = "Shop mobile number is required")
    @Positive(message = "Mobile number must be positive")
    private int spare_parts_shop_mobile;

    @NotNull(message = "Spare part ID is required")
    private int spare_part_id;

    @NotNull(message = "Brand ID is required")
    private int brand_id;
}
