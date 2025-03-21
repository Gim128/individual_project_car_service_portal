package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.AdminDTO;
import com.example.carserviceportal.entity.AdminUser;
import com.example.carserviceportal.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<AdminUser> registerAdmin(@Valid @RequestBody AdminDTO adminDTO){
        AdminUser registeredAdmin = adminService.registerAdmin(adminDTO);
        return new ResponseEntity<>(registeredAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/{admin_email}")
    public ResponseEntity<Optional<AdminUser>> getAdminByEmail(@PathVariable String admin_email){
        Optional<AdminUser> adminUser = adminService.getAdminByEmail(admin_email);
        return new ResponseEntity<>(adminUser, HttpStatus.OK);
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }
}
