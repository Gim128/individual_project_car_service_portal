package com.example.carserviceportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int booking_id;

    @NotNull (message = "Car ID is required")
    private int car_id;

    @NotNull(message = "User ID is required")
    private int user_id;

    @NotNull(message = "Booking price is required")
    @Positive(message = "Booking price must be positive")
    private double booking_price;

    @NotNull(message = "Booking date is required")
    private Data booking_date;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Booking orElseThrow(Object o) {
    }
}
