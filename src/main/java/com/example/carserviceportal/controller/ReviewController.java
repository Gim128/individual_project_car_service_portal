package com.example.carserviceportal.controller;

import com.example.carserviceportal.dto.ReviewDTO;
import com.example.carserviceportal.entity.Review;
import com.example.carserviceportal.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        Review createdReview = reviewService.createReview(reviewDTO);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    @GetMapping("/{review_id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int review_id) {
        Review review = reviewService.getReviewById(review_id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
}
