package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.PartsShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartsShopRepository extends JpaRepository<PartsShop, Integer> {
    Optional<PartsShop> findBySparePartsShopName(String spare_parts_shop_name);
}
