package com.example.carserviceportal.controller;

import com.example.carserviceportal.entity.User;
import com.example.carserviceportal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password){
        User user = authService.authenticateUser(email, password);
        if(user.getRole().equals("ADMIN")){
            return "redirect:/admin/home";
        }else {
            return "redirect:/user/home";
        }
    }
}
