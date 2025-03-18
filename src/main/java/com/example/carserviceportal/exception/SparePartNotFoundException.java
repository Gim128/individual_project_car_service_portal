package com.example.carserviceportal.exception;

public class SparePartNotFoundException extends RuntimeException{
    public SparePartNotFoundException(String message) {
        super(message);
    }
}
