package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Integer> {
    Optional<ServiceCenter> findByServiceCenterName(String service_center_name);
}
