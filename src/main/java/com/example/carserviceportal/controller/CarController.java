package com.example.carserviceportal.controller;

import com.example.carserviceportal.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    
}
