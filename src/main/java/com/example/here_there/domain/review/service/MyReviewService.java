package com.example.here_there.domain.review.service;

import com.example.here_there.domain.review.domain.Review;
import com.example.here_there.domain.review.facade.ReviewFacade;
import com.example.here_there.domain.review.presentation.dto.response.ReviewListResponse;
import com.example.here_there.domain.user.domain.User;
import com.example.here_there.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyReviewService {
    private final ReviewFacade reviewFacade;
    private final UserFacade userFacade;

    public List<ReviewListResponse> execute() {
        User user = userFacade.getCurrentUser();

        List<Review> reviews = reviewFacade.findByUserId(user);

        return reviews.stream()
                .map(review -> ReviewListResponse.builder()
                        .id(review.getId())
                        .title(review.getTitle())
                        .writerName(user.getNickname())
                        .createDate(review.getCreateDate())
                        .Image("http://localhost:8081/" + review.getStoredFileName())
                        .build())
                .collect(Collectors.toList());
    }
}
