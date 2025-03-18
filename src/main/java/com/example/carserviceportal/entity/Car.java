package com.example.carserviceportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_id;

    @NotNull(message = "Manufacture year is required")
    private Date manufacture_year;

//    @NotNull(message = "Registered year is required")
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
