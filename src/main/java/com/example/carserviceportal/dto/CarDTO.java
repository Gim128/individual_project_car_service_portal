package com.example.carserviceportal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class CarDTO {
    @NotNull(message = "Manufacture Year is required")
    private Date manufacture_year;

    @Setter
    @Getter
    private Date registered_year;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private double price;

    @NotNull(message = "Approve ID is required")
    private int approve_id;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Category ID is required")
    private int category_id;

    @NotNull(message = "User ID is required")
    private int user_id;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Brand ID is required")
    private int car_brand;

}
