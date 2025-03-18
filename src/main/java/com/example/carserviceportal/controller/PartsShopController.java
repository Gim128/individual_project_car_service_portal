package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.PartsShopDTO;
import com.example.carserviceportal.entity.PartsShop;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parts_shop")
public class PartsShopController {
    @Autowired
    private PartsShopController partsShopController;

    @PostMapping("/create")
    public ResponseEntity<PartsShop> createPartsShop(@Valid @RequestBody PartsShopDTO partsShopDTO) {
        PartsShop createdPartsShop = partsShopService.createPartsShop(partsShopDTO);
        return new ResponseEntity<>(createdPartsShop, HttpStatus.CREATED);
    }

    @GetMapping("/{part_shop_id}")
    public ResponseEntity<PartsShop> getPartsShopById(@PathVariable int part_shop_id) {
        PartsShop partsShop = partsShopService.getPartsShopById(part_shop_id);
        return new ResponseEntity<>(partsShop, HttpStatus.OK);
    }
}
