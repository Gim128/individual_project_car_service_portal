package com.example.carserviceportal.exception;

public class ServiceCenterNotFoundException extends RuntimeException {
    public ServiceCenterNotFoundException(String message) {
        super(message);
    }
}
