package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.PaymentDTO;
import com.example.carserviceportal.entity.Payment;
import com.example.carserviceportal.repository.PaymentRepository;
import com.example.carserviceportal.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@Valid @RequestBody PaymentDTO paymentDTO) {
        Payment createdPayment = paymentService.createPayment(paymentDTO);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @GetMapping("/{payment_id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int payment_id) {
        Payment payment = paymentService.getPaymentById(payment_id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
