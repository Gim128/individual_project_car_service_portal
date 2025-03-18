package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.BrandDTO;
import com.example.carserviceportal.entity.Brand;
import com.example.carserviceportal.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandController brandController;
    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    public ResponseEntity<Brand> createBrand(@Valid @RequestBody BrandDTO brandDTO) {
        Brand createdBrand = brandService.createBrand(brandDTO);
        return new ResponseEntity<>(createdBrand, HttpStatus.CREATED);
    }

    @GetMapping("/{brand_id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable int brand_id) {
        Brand brand = brandService.getBrandById(brand_id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }
}
