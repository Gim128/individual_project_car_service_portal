package com.example.carserviceportal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentDTO {
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
