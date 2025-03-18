package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.SparePartDTO;
import com.example.carserviceportal.dto.SparePartsCategoryDTO;
import com.example.carserviceportal.entity.SparePart;
import com.example.carserviceportal.entity.SparePartsCategory;
import com.example.carserviceportal.service.SparePartService;
import com.example.carserviceportal.service.SparePartsCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spare-parts-categories")
public class SparePartsCategoryController {
    @Autowired
    private SparePartService sparePartService;

    @PostMapping("/create")
    public ResponseEntity<SparePart> createSparePart(@Valid @RequestBody SparePartDTO sparePartDTO) {
        SparePart createdSparePart = sparePartService.createSparePart(sparePartDTO);
        return new ResponseEntity<>(createdSparePart, HttpStatus.CREATED);
    }

    @GetMapping("/{spare_part_id}")
    public ResponseEntity<SparePart> getSparePartById(@PathVariable int spare_part_id) {
        SparePart sparePart = sparePartService.getSparePartById(spare_part_id);
        return new ResponseEntity<>(sparePart, HttpStatus.OK);
    }

}
