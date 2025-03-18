package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.UserDTO;
import com.example.carserviceportal.entity.User;
import com.example.carserviceportal.exception.UserAlreadyExistsException;
import com.example.carserviceportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDTO userDTO){
        if (userRepository.findByEmail(userDTO.getEmail()) != null){
            throw new UserAlreadyExistsException("User with email " + userDTO.getEmail() + " Already Exists");
        }

        User user = new User();
        user.setFirst_name(userDTO.getFirst_name());
        user.setLast_name(userDTO.getLast_name());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUser_type(userDTO.getUser_type());
        user.setAddress(userDTO.getAddress());
        user.setMobile(userDTO.getMobile());

        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
