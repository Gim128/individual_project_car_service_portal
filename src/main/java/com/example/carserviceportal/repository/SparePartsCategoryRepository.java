package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.SparePart;
import com.example.carserviceportal.entity.SparePartsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SparePartsCategoryRepository extends JpaRepository<SparePartsCategory, Integer> {
    Optional<SparePartsCategory> findBySparePartCategoryName(String spare_part_category_name);
}
