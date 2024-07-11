package com.example.here_there.domain.user.service;


import com.example.here_there.domain.user.domain.User;
import com.example.here_there.domain.user.facade.UserFacade;
import com.example.here_there.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.here_there.domain.user.presentation.dto.response.TokenResponse;
import com.example.here_there.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLoginService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(UserLoginRequest request){
        User user = userFacade.findByEmail(request.getEmail());
        userFacade.checkPassword(user, request.getPassword());

        String accessToken = jwtTokenProvider.generateAccessToken(user.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
