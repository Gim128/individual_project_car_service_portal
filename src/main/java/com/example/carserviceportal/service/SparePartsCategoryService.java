package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.SparePartsCategoryDTO;
import com.example.carserviceportal.entity.SparePart;
import com.example.carserviceportal.entity.SparePartsCategory;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.exception.SparePartNotFoundException;
import com.example.carserviceportal.exception.SparePartsCategoryNotFoundException;
import com.example.carserviceportal.repository.SparePartsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SparePartsCategoryService {
    @Autowired
    private SparePartsCategoryRepository sparePartsCategoryRepository;

    public SparePartsCategory createSparePartsCategory(SparePartsCategoryDTO sparePartsCategoryDTO) {
        // Check if category already exists
        if (sparePartsCategoryRepository.findBySparePartCategoryName(sparePartsCategoryDTO.getSpare_part_category_name()).isPresent()) {
            throw new InvalidDataException("Category with name " + sparePartsCategoryDTO.getSpare_part_category_name() + " already exists");
        }

        // Map DTO to Entity
        SparePartsCategory sparePartsCategory = new SparePartsCategory();
        sparePartsCategory.setSpare_part_category_name(sparePartsCategoryDTO.getSpare_part_category_name());
        sparePartsCategory.setPart_desc(sparePartsCategoryDTO.getPart_desc());

        return sparePartsRepository.save(sparePart);
    }

    public SparePart getSparePartById(int spare_part_id) {
        return sparePartRepository.findById(spare_part_id)
                .orElseThrow(() -> new SparePartNotFoundException("Spare part with ID " + spare_part_id + " not found"));
    }
}
