package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.PaymentDTO;
import com.example.carserviceportal.entity.Payment;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.exception.PaymentNotFoundException;
import com.example.carserviceportal.repository.CarRepository;
import com.example.carserviceportal.repository.PaymentRepository;
import com.example.carserviceportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    public Payment createPayment(PaymentDTO paymentDTO) {
        // Check if buyer exists
        if (!userRepository.existsById(paymentDTO.getBuyer_id())) {
            throw new InvalidDataException("Buyer with ID " + paymentDTO.getBuyer_id() + " not found");
        }

        // Check if car exists
        if (!carRepository.existsById(paymentDTO.getCar_id())) {
            throw new InvalidDataException("Car with ID " + paymentDTO.getCar_id() + " not found");
        }

        // Map DTO to Entity
        Payment payment = new Payment();
        payment.setPayment_amount(paymentDTO.getPayment_amount());
        payment.setPayment_date(paymentDTO.getPayment_date());
        payment.setBuyer_id(paymentDTO.getBuyer_id());
        payment.setCar_id(paymentDTO.getCar_id());

        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(int payment_id) {
        return paymentRepository.findByPaymentId(payment_id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with ID " + payment_id + " not found"));
    }
}
