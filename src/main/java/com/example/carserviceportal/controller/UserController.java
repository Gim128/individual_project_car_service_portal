package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.UserDTO;
import com.example.carserviceportal.entity.User;
import com.example.carserviceportal.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO userDTO) {
        User registeredUser = userService.registerUser(userDTO);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
