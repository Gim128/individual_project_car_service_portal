package com.example.carserviceportal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class SubscriptionDTO {
    @NotBlank(message = "Subscription description is required")
    private String subscription_desc;

    @NotNull(message = "Subscription amount is required")
    @Positive(message = "Subscription amount must be positive")
    private double subscription_amount;

    @NotNull(message = "Number of ads is required")
    @PositiveOrZero(message = "Number of ads must be positive or zero")
    private int no_of_ads;

    @NotNull(message = "User ID is required")
    private int user_id;
}
