package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.SubscriptionDTO;
import com.example.carserviceportal.entity.Subscription;
import com.example.carserviceportal.service.SubscriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/create")
    public ResponseEntity<Subscription> createSubscription(@Valid @RequestBody SubscriptionDTO subscriptionDTO) {
        Subscription createdSubscription = subscriptionService.createSubscription(subscriptionDTO);
        return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
    }

    @GetMapping("/{subscription_id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable int subscription_id) {
        Subscription subscription = subscriptionService.getSubscriptionById(subscription_id);
        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }

}
