package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SparePartRepository extends JpaRepository<SparePart, Integer> {
    Optional<SparePart> findBySparePartName(String spare_part_name);
}
