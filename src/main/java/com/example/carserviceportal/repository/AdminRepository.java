package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminUser, Integer> {
    Optional<AdminUser> findByAdminEmail(String admin_email);
}
