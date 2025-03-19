package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.ServiceCenterDTO;
import com.example.carserviceportal.entity.ServiceCenter;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.exception.ServiceCenterNotFoundException;
import com.example.carserviceportal.repository.ServiceCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCenterService {
    @Autowired
    private ServiceCenterRepository serviceCenterRepository;

    public ServiceCenter createServiceCenter(ServiceCenterDTO serviceCenterDTO) {
        // Check if service center already exists
        if (serviceCenterRepository.findByServiceCenterName(serviceCenterDTO.getService_center_name()).isPresent()) {
            throw new InvalidDataException("Service center with name " + serviceCenterDTO.getService_center_name() + " already exists");
        }

        // Map DTO to Entity
        ServiceCenter serviceCenter = new ServiceCenter();
        serviceCenter.setService_center_name(serviceCenterDTO.getService_center_name());
        serviceCenter.setService_center_mobile(serviceCenterDTO.getService_center_mobile());
        serviceCenter.setService_center_email(serviceCenterDTO.getService_center_email());
        serviceCenter.setService_center_location(serviceCenterDTO.getService_center_location());

        // Save the service center to the database
        return serviceCenterRepository.save(serviceCenter);
    }

    public ServiceCenter getServiceCenterById(int service_center_id) {
        return serviceCenterRepository.findById(service_center_id)
                .orElseThrow(() -> new ServiceCenterNotFoundException("Service center with ID " + service_center_id + " not found"));
    }

}
