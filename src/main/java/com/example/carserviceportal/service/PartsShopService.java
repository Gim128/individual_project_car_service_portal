package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.PartsShopDTO;
import com.example.carserviceportal.entity.PartsShop;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.repository.BrandRepository;
import com.example.carserviceportal.repository.PartsShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartsShopService {
    @Autowired
    private PartsShopRepository partsShopRepository;

    @Autowired
    private SparePartRepository sparePartRepository;

    @Autowired
    private BrandRepository brandRepository;

    public PartsShop createPartsShop(PartsShopDTO partsShopDTO) {
        // Check if spare part exists
        if (!sparePartRepository.existsById(partsShopDTO.getSpare_part_id())) {
            throw new InvalidDataException("Spare part with ID " + partsShopDTO.getSpare_part_id() + " not found");
        }

        // Check if brand exists
        if (!brandRepository.existsById(partsShopDTO.getBrand_id())) {
            throw new InvalidDataException("Brand with ID " + partsShopDTO.getBrand_id() + " not found");
        }

        // Check if shop already exists
        if (partsShopRepository.findBySparePartsShopName(partsShopDTO.getSpare_parts_shop_name()).isPresent()) {
            throw new InvalidDataException("Parts shop with name " + partsShopDTO.getSpare_parts_shop_name() + " already exists");
        }

        // Map DTO to Entity
        PartsShop partsShop = new PartsShop();
        partsShop.setSpare_parts_shop_name(partsShopDTO.getSpare_parts_shop_name());
        partsShop.setSpare_part_shop_address(partsShopDTO.getSpare_part_shop_address());
        partsShop.setSpare_parts_shop_mobile(partsShopDTO.getSpare_parts_shop_mobile());
        partsShop.setSpare_part_id(partsShopDTO.getSpare_part_id());
        partsShop.setBrand_id(partsShopDTO.getBrand_id());

        return partsShopRepository.save(partsShop);
    }

    public PartsShop getPartsShopById(int part_shop_id) {
        return partsShopRepository.findById(part_shop_id)
                .orElseThrow(() -> new PartsShopNotFoundException("Parts shop with ID " + part_shop_id + " not found"));
    }
}
