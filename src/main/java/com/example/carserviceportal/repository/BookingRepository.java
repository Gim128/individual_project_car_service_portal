package com.example.carserviceportal.repository;

import com.example.carserviceportal.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findByBookingId(int booking_id);
}
