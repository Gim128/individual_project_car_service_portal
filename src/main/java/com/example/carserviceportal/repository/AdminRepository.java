package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminUser, Integer> {
    AdminUser findByAdminEmail(String admin_email);
}
