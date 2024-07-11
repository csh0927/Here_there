package com.example.here_there.domain.review.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class ReviewListResponse {
    private final Long id;
    private final String title;
    private final String writerName;
    private final LocalDateTime createDate;
    private final String Image;
}
