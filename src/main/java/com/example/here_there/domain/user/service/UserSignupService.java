package com.example.here_there.domain.user.service;

import com.example.here_there.domain.user.domain.repository.UserRepository;
import com.example.here_there.domain.user.facade.UserFacade;
import com.example.here_there.domain.user.presentation.dto.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import com.example.here_there.domain.user.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignupService {
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UserSignupRequest request) {
        userFacade.checkUserExist(request.getEmail());

        userRepository.save(User.builder()
                .nickname(request.getNickname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());
    }
}
