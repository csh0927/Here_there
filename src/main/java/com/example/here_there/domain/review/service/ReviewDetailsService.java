package com.example.here_there.domain.review.service;


import com.example.here_there.domain.review.domain.Review;
import com.example.here_there.domain.review.facade.ReviewFacade;
import com.example.here_there.domain.review.presentation.dto.response.ReviewDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ReviewDetailsService {
    private final ReviewFacade reviewFacade;

    public ReviewDetailsResponse execute(Long reviewId) {
        Review review = reviewFacade.findByReviewId(reviewId);

        return ReviewDetailsResponse.builder()
                .id(reviewId)
                .title(review.getTitle())
                .content(review.getContent())
                .Image("http://localhost:8081/" + review.getStoredFileName())
                .interests(review.getInterests())
                .region(review.getRegion())
                .country(review.getCountry())
                .address(review.getAddress())
                .build();

    }
}
