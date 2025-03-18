package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.CategoryDTO;
import com.example.carserviceportal.entity.Category;
import com.example.carserviceportal.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        Category createCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int category_id){
        Category category = categoryService.getCategoryById(category_id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
