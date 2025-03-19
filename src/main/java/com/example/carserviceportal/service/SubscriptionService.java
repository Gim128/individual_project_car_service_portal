package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.SubscriptionDTO;
import com.example.carserviceportal.entity.Subscription;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.exception.SubscriptionNotFoundException;
import com.example.carserviceportal.repository.SubscriptionRepository;
import com.example.carserviceportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    public Subscription createSubscription(SubscriptionDTO subscriptionDTO) {
        // Check if user exists
        if (!userRepository.existsById(subscriptionDTO.getUser_id())) {
            throw new InvalidDataException("User with ID " + subscriptionDTO.getUser_id() + " not found");
        }

        // Map DTO to Entity
        Subscription subscription = new Subscription();
        subscription.setSubscription_desc(subscriptionDTO.getSubscription_desc());
        subscription.setSubscription_amount(subscriptionDTO.getSubscription_amount());
        subscription.setNo_of_ads(subscriptionDTO.getNo_of_ads());
        subscription.setUser_id(subscriptionDTO.getUser_id());

        // Save the subscription to the database
        return subscriptionRepository.save(subscription);
    }

    public Subscription getSubscriptionById(int subscription_id) {
        return subscriptionRepository.findBySubscriptionId(subscription_id)
                .orElseThrow(() -> new SubscriptionNotFoundException("Subscription with ID " + subscription_id + " not found"));
    }
}
