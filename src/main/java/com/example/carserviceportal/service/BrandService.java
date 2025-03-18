package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.BrandDTO;
import com.example.carserviceportal.entity.Brand;
import com.example.carserviceportal.exception.BrandNotFoundException;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand createBrand(BrandDTO brandDTO) {
        // Check if brand already exists
        if (brandRepository.findByBrandName(brandDTO.getBrand_name()).isPresent()) {
            throw new InvalidDataException("Brand with name " + brandDTO.getBrand_name() + " already exists");
        }

        // Map DTO to Entity
        Brand brand = new Brand();
        brand.setBrand_name(brandDTO.getBrand_name());
        brand.setBrand_desc(brandDTO.getBrand_desc());

        return brandRepository.save(brand);
    }

    public Brand getBrandById(int brand_id) {
        return brandRepository.findById(brand_id)
                .orElseThrow(() -> new BrandNotFoundException("Brand with ID " + brand_id + " not found"));
    }
}
