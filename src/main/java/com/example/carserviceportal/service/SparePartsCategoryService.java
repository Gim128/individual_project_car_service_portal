package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.SparePartsCategoryDTO;
import com.example.carserviceportal.entity.SparePart;
import com.example.carserviceportal.entity.SparePartsCategory;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.exception.SparePartNotFoundException;
import com.example.carserviceportal.exception.SparePartsCategoryNotFoundException;
import com.example.carserviceportal.repository.SparePartRepository;
import com.example.carserviceportal.repository.SparePartsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SparePartsCategoryService {
    @Autowired
    private SparePartsCategoryRepository sparePartsCategoryRepository;
    @Autowired
    private SparePartRepository sparePartRepository;

//    public SparePartsCategory createSparePartsCategory(SparePartsCategoryDTO sparePartsCategoryDTO) {
//        // Check if category already exists
//        if (sparePartsCategoryRepository.findBySparePartCategoryName(sparePartsCategoryDTO.getSpare_part_name()).isPresent()) {
//            throw new InvalidDataException("Category with name " + sparePartsCategoryDTO.getSpare_part_name() + " already exists");
//        }
//
//        // Map DTO to Entity
//        SparePartsCategory sparePartsCategory = new SparePartsCategory();
//        sparePartsCategory.setSpare_part_name(sparePartsCategoryDTO.getSpare_part_name());
//        sparePartsCategory.setSpare_part_description(sparePartsCategoryDTO.getSpare_part_description());
//
//        return sparePartRepository.save(sparePartsCategory);
//    }

    public SparePartsCategory createSparePartsCategory(SparePartsCategoryDTO sparePartsCategoryDTO) {
        // Check if category already exists
        if (sparePartsCategoryRepository.findBySparePartCategoryName(sparePartsCategoryDTO.getSpare_part_name()).isPresent()) {
            throw new InvalidDataException("Category with name " + sparePartsCategoryDTO.getSpare_part_name() + " already exists");
        }

        // Map DTO to Entity
        SparePartsCategory sparePartsCategory = new SparePartsCategory();
        sparePartsCategory.setSpare_part_category_id(Integer.parseInt(sparePartsCategoryDTO.getSpare_part_name()));
        sparePartsCategory.set_active(Boolean.parseBoolean(sparePartsCategoryDTO.getSpare_part_description()));

        // Save the category using the correct repository
        return sparePartsCategoryRepository.save(sparePartsCategory);
    }

    public SparePart getSparePartById(int spare_part_id) {
        return sparePartRepository.findById(spare_part_id)
                .orElseThrow(() -> new SparePartNotFoundException("Spare part with ID " + spare_part_id + " not found"));
    }
}
