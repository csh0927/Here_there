package com.example.here_there.domain.review.service;

import com.example.here_there.domain.review.facade.ReviewFacade;
import com.example.here_there.domain.review.presentation.dto.response.ReviewListResponse;
import com.example.here_there.domain.user.domain.Interest;
import com.example.here_there.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecommendReviewService {
    private final UserFacade userFacade;
    private final ReviewFacade reviewFacade;

    public List<ReviewListResponse> execute() {
        List<Interest> interests = userFacade.getCurrentUser().getInterests();

        List<ReviewListResponse> reviews = reviewFacade.findByInterestIn(interests).stream()
                .map(review -> ReviewListResponse.builder()
                        .id(review.getId())
                        .title(review.getTitle())
                        .writerName(review.getUser().getNickname())
                        .createDate(review.getCreateDate())
                        .Image("http://localhost:8081/" + review.getStoredFileName())
                        .build())
                .collect(Collectors.toList());

        Collections.shuffle(reviews);

        return reviews;
    }
}
