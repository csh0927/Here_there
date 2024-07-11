package com.example.here_there.domain.review.presentation.dto.response;


import com.example.here_there.domain.user.domain.Interest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class ReviewDetailsResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String Image;
    private final List<Interest> interests;
    private final String region;
    private final String address;
    private final String country;
}
