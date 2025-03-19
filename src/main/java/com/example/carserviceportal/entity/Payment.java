package com.example.carserviceportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    @NotNull(message = "Payment amount is required")
    @Positive(message = "Payment amount must be positive")
    private double payment_amount;

    @NotNull(message = "Payment date is required")
    private Date payment_date;

    @NotNull(message = "Buyer ID is required")
    private int buyer_id;

    @NotNull(message = "Car ID is required")
    private int car_id;
}
