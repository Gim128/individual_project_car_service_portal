package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.BookingDTO;
import com.example.carserviceportal.entity.Booking;
import com.example.carserviceportal.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody BookingDTO bookingDTO){
        Booking createBooking = bookingService.createBooking(bookingDTO);
        return new  ResponseEntity<>(createBooking,HttpStatus.CREATED);
    }

    @GetMapping("/{booking_id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int booking_id){
        Booking booking = bookingService.getBookingById(booking_id);
        return new ResponseEntity<>(booking,HttpStatus.OK);
    }

}
