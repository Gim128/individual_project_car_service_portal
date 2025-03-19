package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    Optional<Subscription> findBySubscriptionId(int subscription_id);
}
