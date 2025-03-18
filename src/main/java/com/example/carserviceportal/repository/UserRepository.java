package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
//    User findByEmail(String email);
    Optional<User> findByEmail(String email);

//    String email(@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email);
}
