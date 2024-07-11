package com.example.here_there.domain.user.service;

import com.example.here_there.domain.review.facade.ReviewFacade;
import com.example.here_there.domain.user.domain.User;
import com.example.here_there.domain.user.facade.UserFacade;
import com.example.here_there.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.here_there.domain.user.presentation.dto.response.UserPercentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserInfoService {
    private final UserFacade userFacade;
    private final ReviewFacade reviewFacade;

    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();

        List<String> countryList = reviewFacade.findCountryByUserId(user.getId());

        Map<String, Integer> countryCounts = new HashMap<>();
        for (String country : countryList) {
            countryCounts.put(country, countryCounts.getOrDefault(country, 0) + 1);
        }

        List<UserPercentResponse> percentList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countryCounts.entrySet()) {
            percentList.add(new UserPercentResponse(entry.getKey(), entry.getValue()));
        }

        return UserInfoResponse.builder()
                .nickname(user.getNickname())
                .email(user.getEmail())
                .interests(user.getInterests())
                .percent(percentList)
                .Image("http://localhost:8081/" + user.getStoredFileName())
                .build();
    }
}
