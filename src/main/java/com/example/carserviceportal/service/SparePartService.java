package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.SparePartDTO;
import com.example.carserviceportal.entity.SparePart;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.exception.SparePartNotFoundException;
import com.example.carserviceportal.repository.BrandRepository;
import com.example.carserviceportal.repository.SparePartRepository;
import com.example.carserviceportal.repository.SparePartsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SparePartService {
    @Autowired
    private SparePartRepository sparePartRepository;

    @Autowired
    private SparePartsCategoryRepository sparePartsCategoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    public SparePart createSparePart(SparePartDTO sparePartDTO) {
        // Check if spare part category exists
        if (!sparePartsCategoryRepository.existsById(sparePartDTO.getSpare_part_category_id())) {
            throw new InvalidDataException("Spare part category with ID " + sparePartDTO.getSpare_part_category_id() + " not found");
        }

        // Check if brand exists
        if (!brandRepository.existsById(sparePartDTO.getSpare_parts_brand())) {
            throw new InvalidDataException("Brand with ID " + sparePartDTO.getSpare_parts_brand() + " not found");
        }

        // Check if spare part already exists
        if (sparePartRepository.findBySparePartName(sparePartDTO.getSpare_part_name()).isPresent()) {
            throw new InvalidDataException("Spare part with name " + sparePartDTO.getSpare_part_name() + " already exists");
        }

        // Map DTO to Entity
        SparePart sparePart = new SparePart();
        sparePart.setSpare_part_name(sparePartDTO.getSpare_part_name());
        sparePart.setSpare_part_description(sparePartDTO.getSpare_part_description());
        sparePart.setSpare_part_category_id(sparePartDTO.getSpare_part_category_id());
        sparePart.setSpare_parts_brand(sparePartDTO.getSpare_parts_brand());
        sparePart.setSpare_part_price(sparePartDTO.getSpare_part_price());
        sparePart.setSpare_part_qty(sparePartDTO.getSpare_part_qty());

        return sparePartRepository.save(sparePart);
    }

    public SparePart getSparePartById(int spare_part_id) {
        return sparePartRepository.findById(spare_part_id)
                .orElseThrow(() -> new SparePartNotFoundException("Spare part with ID " + spare_part_id + " not found"));
    }
}
