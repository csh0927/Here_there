package com.example.here_there.domain.review.presentation.dto.request;

import com.example.here_there.domain.user.domain.Interest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
public class ReviewCreateRequest {
    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private List<Interest> interests;

    @NotNull
    private String country;

    @NotNull
    private String region;

    @NotNull
    private String address;
}
