package com.example.here_there.domain.user.presentation.dto.response;

import com.example.here_there.domain.user.domain.Interest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class UserInfoResponse {
    private final String nickname;
    private final String email;
    private final List<Interest> interests;
    private final List<UserPercentResponse> percent;
    private final String Image;
}
