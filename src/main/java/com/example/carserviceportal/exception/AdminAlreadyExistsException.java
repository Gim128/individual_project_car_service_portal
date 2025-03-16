package com.example.carserviceportal.exception;

public class AdminAlreadyExistsException extends RuntimeException{
    public AdminAlreadyExistsException(String message) {
        super(message);
    }
}
