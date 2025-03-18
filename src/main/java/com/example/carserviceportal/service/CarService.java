package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.CarDTO;
import com.example.carserviceportal.entity.Car;
import com.example.carserviceportal.exception.CarNotFoundException;
import com.example.carserviceportal.repository.CarRepository;
import com.example.carserviceportal.repository.CategoryRepository;
import com.example.carserviceportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BrandRepository brandRepository;

    public Car createCar(CarDTO carDTO){
        if (!categoryRepository.existsById(carDTO.getCategory_id())){
            throw new RuntimeException("Category with ID " + carDTO.getCategory_id() + " not found");
        }

        if (!userRepository.existsById(carDTO.getUser_id())){
            throw new RuntimeException("User with ID " + carDTO.getUser_id() + " not found");
        }

        if (!brandRepository.existsById(carDTO.getCar_brand())){
            throw new RuntimeException("Brand with ID " + carDTO.getCar_brand() + " not found");
        }

        Car car = new Car();
        car.setManufacture_year(carDTO.getManufacture_year());
        car.setRegistered_year(carDTO.getRegistered_year());
        car.setPrice(carDTO.getPrice());
        car.setApprove_id(carDTO.getApprove_id());
        car.setModel(carDTO.getModel());
        car.setCategory_id(carDTO.getCategory_id());
        car.setUser_id(carDTO.getUser_id());
        car.setDescription(carDTO.getDescription());
        car.setCar_brand(carDTO.getCar_brand());

        return carRepository.save(car);
    }

    public Car getCarById(int car_id) {
        return carRepository.findByCarId(car_id)
                .orElseThrow();
    }
}
