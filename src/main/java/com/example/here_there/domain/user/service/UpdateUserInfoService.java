package com.example.here_there.domain.user.service;

import com.example.here_there.domain.user.domain.User;
import com.example.here_there.domain.user.facade.UserFacade;
import com.example.here_there.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInfoService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateUserInfoRequest request) {
        User user = userFacade.getCurrentUser();

        user.update(request.getNickname(), request.getEmail());
    }
}