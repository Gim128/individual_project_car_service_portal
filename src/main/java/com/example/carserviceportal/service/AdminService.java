package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.AdminDTO;
import com.example.carserviceportal.entity.AdminUser;
import com.example.carserviceportal.exception.AdminAlreadyExistsException;
import com.example.carserviceportal.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminUser registerAdmin(AdminDTO adminDTO){
        if (adminRepository.findByAdminEmail(adminDTO.getAdmin_email()) != null) {
            throw new AdminAlreadyExistsException("Admin with email " + adminDTO.getAdmin_email() + " already exists");
        }

        AdminUser adminUser = new AdminUser();
        adminUser.setAdmin_name(adminDTO.getAdmin_name());
        adminUser.setAdmin_email(adminDTO.getAdmin_email());
        adminUser.setAdmin_password(adminDTO.getAdmin_Password());

        return adminRepository.save(adminUser);
    }

    public Optional<AdminUser> getAdminByEmail(String admin_email) {
        return adminRepository.findByAdminEmail(admin_email);
    }
}
