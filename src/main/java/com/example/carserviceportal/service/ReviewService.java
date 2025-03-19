package com.example.carserviceportal.service;

import com.example.carserviceportal.dto.ReviewDTO;
import com.example.carserviceportal.entity.Review;
import com.example.carserviceportal.exception.InvalidDataException;
import com.example.carserviceportal.exception.ReviewNotFoundException;
import com.example.carserviceportal.repository.ReviewRepository;
import com.example.carserviceportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    public Review createReview(ReviewDTO reviewDTO) {
        // Check if seller exists
        if (!userRepository.existsById(reviewDTO.getSeller_id())) {
            throw new InvalidDataException("Seller with ID " + reviewDTO.getSeller_id() + " not found");
        }

        // Check if reviewer exists
        if (!userRepository.existsById(reviewDTO.getReviewer_id())) {
            throw new InvalidDataException("Reviewer with ID " + reviewDTO.getReviewer_id() + " not found");
        }

        // Map DTO to Entity
        Review review = new Review();
        review.setDescription(reviewDTO.getDescription());
        review.setSeller_id(reviewDTO.getSeller_id());
        review.setRating(reviewDTO.getRating());
        review.setReviewer_id(reviewDTO.getReviewer_id());

        return reviewRepository.save(review);
    }

    public Review getReviewById(int review_id) {
        return reviewRepository.findByReviewId(review_id)
                .orElseThrow(() -> new ReviewNotFoundException("Review with ID " + review_id + " not found"));
    }
}
