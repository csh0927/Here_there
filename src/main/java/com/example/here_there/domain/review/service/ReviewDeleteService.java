package com.example.here_there.domain.review.service;

import com.example.here_there.domain.review.domain.Review;
import com.example.here_there.domain.review.domain.repository.ReviewRepository;
import com.example.here_there.domain.review.facade.ReviewFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewDeleteService {
    private final ReviewRepository boardRepository;
    private final ReviewFacade boardFacade;

    @Transactional
    public void execute(Long reviewId) {
        Review review = boardFacade.findByReviewId(reviewId);
        boardFacade.checkWriter(review);

        boardRepository.delete(review);
    }
}
