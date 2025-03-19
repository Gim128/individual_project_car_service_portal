package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.BookingDTO;
import com.example.carserviceportal.entity.Booking;
import com.example.carserviceportal.exception.BookingNotFoundException;
import com.example.carserviceportal.exception.CarNotFoundException;
import com.example.carserviceportal.repository.BookingRepository;
import com.example.carserviceportal.repository.CarRepository;
import com.example.carserviceportal.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Supplier;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;
    private int bookingId;

    public Booking createBooking(BookingDTO bookingDTO) {
        // Check if car exists
        if (!carRepository.existsById(bookingDTO.getCar_id())) {
            throw new CarNotFoundException("Car with ID " + bookingDTO.getCar_id() + " not found");
        }

        // Check if user exists
        if (!userRepository.existsById(bookingDTO.getUser_id())) {
            throw new RuntimeException("User with ID " + bookingDTO.getUser_id() + " not found");
        }

        // Map DTO to Entity
        Booking booking = new Booking();
        booking.setCar_id(bookingDTO.getCar_id());
        booking.setUser_id(bookingDTO.getUser_id());
        booking.setBooking_price(bookingDTO.getBooking_price());
        booking.setBooking_date((Date) bookingDTO.getBooking_date());

        return bookingRepository.save(booking);
    }

    private Supplier<BookingNotFoundException> bookingNotFound(int booking_id) {
        return () -> new BookingNotFoundException("Booking with ID " + booking_id + " not found");
    }

    public Booking getBookingById(int booking_id) {
        return bookingRepository.findByBookingId(booking_id)
                .orElseThrow(bookingNotFound(booking_id));
    }
}
