package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.CarDTO;
import com.example.carserviceportal.entity.Car;
import com.example.carserviceportal.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@Valid @RequestBody CarDTO carDTO) {
        Car createdCar = carService.createCar(carDTO);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping("/{car_id}")
    public ResponseEntity<Car> getCarById(@PathVariable int car_id) {
        Car car = carService.getCarById(car_id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    
}
