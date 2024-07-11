package com.example.here_there.domain.review.facade;

import com.example.here_there.domain.review.domain.Review;
import com.example.here_there.domain.review.domain.repository.ReviewRepository;
import com.example.here_there.domain.review.exception.ReviewNotFoundException;
import com.example.here_there.domain.review.exception.WriterMismatchedException;
import com.example.here_there.domain.user.domain.Interest;
import com.example.here_there.domain.user.domain.User;
import com.example.here_there.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Component
public class ReviewFacade {
    private final ReviewRepository reviewRepository;
    private final UserFacade userFacade;

    public void checkWriter(Review review) {
        if(!userFacade.getCurrentUser().getNickname().equals(review.getUser().getNickname()))
            throw WriterMismatchedException.EXCEPTION;
    }

    public Review findByReviewId(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> ReviewNotFoundException.EXCEPTION);
    }

    public List<String> findCountryByUserId(Long userId) {
        return reviewRepository.findCountryByUserId(userId);
    }

    public List<Review> findByUserId(User user) {
        return reviewRepository.findByUser(user);
    }

    public List<Review> findByTitleContaining(String keyword) {
        return reviewRepository.findByTitleContaining(keyword);
    }

    public List<Review> findByInterestIn(List<Interest> interests) {
        return reviewRepository.findByInterestsIn(interests);
    }
}
