package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.ServiceCenterDTO;
import com.example.carserviceportal.entity.ServiceCenter;
import com.example.carserviceportal.service.ServiceCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-centers")
public class ServiceCenterController {
    @Autowired
    private ServiceCenterService serviceCenterService;

    @PostMapping("/create")
    public ResponseEntity<ServiceCenter> createServiceCenter(@Valid @RequestBody ServiceCenterDTO serviceCenterDTO) {
        ServiceCenter createdServiceCenter = serviceCenterService.createServiceCenter(serviceCenterDTO);
        return new ResponseEntity<>(createdServiceCenter, HttpStatus.CREATED);
    }

    @GetMapping("/{service_center_id}")
    public ResponseEntity<ServiceCenter> getServiceCenterById(@PathVariable int service_center_id) {
        ServiceCenter serviceCenter = serviceCenterService.getServiceCenterById(service_center_id);
        return new ResponseEntity<>(serviceCenter, HttpStatus.OK);
    }
}
