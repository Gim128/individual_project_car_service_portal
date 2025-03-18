package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findByCarId(int car_id);
}
