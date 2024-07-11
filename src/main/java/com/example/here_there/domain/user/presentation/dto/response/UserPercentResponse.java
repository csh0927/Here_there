package com.example.here_there.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class UserPercentResponse {
    private final String country;
    private final Integer percent;
}
