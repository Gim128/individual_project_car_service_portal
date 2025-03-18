package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.CategoryDTO;
import com.example.carserviceportal.entity.Category;
import com.example.carserviceportal.exception.CategoryNotFoundException;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(CategoryDTO categoryDTO) {
        // Check if category already exists
        if (categoryRepository.findByCategoryName(categoryDTO.getCategory_name()).isPresent()) {
            throw new InvalidDataException("Category with name " + categoryDTO.getCategory_name() + " already exists");
        }

        // Map DTO to Entity
        Category category = new Category();
        category.setCategory_name(categoryDTO.getCategory_name());
        category.setCategory_description(categoryDTO.getCategory_description());

        return categoryRepository.save(category);
    }

    public Category getCategoryById(int category_id) {
        return categoryRepository.findById(category_id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with ID " + category_id + " not found"));
    }
}
