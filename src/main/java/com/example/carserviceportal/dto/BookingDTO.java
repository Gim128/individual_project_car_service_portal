package com.example.carserviceportal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

@Data
public class BookingDTO {
    @NotNull(message = "Car ID is required")
    private int car_id;

    @NotNull(message = "User ID is required")
    private int user_id;

    @NotNull(message = "Booking price is required")
    @Positive(message = "Booking price must be positive")
    private double booking_price;

    @NotNull(message = "Booking date is required")
    private Date booking_date;
}
