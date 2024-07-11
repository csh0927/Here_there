package com.example.here_there.domain.review.service;

import com.example.here_there.domain.review.facade.ReviewFacade;
import com.example.here_there.domain.review.presentation.dto.response.ReviewListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchReviewService {
    private final ReviewFacade reviewFacade;

    public List<ReviewListResponse> execute(String keyword) {

        return reviewFacade.findByTitleContaining(keyword).stream()
                .map(review -> ReviewListResponse.builder()
                        .id(review.getId())
                        .title(review.getTitle())
                        .writerName(review.getUser().getNickname())
                        .createDate(review.getCreateDate())
                        .Image("http://localhost:8081/" + review.getStoredFileName())
                        .build())
                .collect(Collectors.toList());
    }
}
