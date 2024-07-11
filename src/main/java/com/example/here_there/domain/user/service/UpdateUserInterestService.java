package com.example.here_there.domain.user.service;

import com.example.here_there.domain.user.domain.User;
import com.example.here_there.domain.user.facade.UserFacade;
import com.example.here_there.domain.user.presentation.dto.request.UpdateUserInterestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInterestService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateUserInterestRequest request) {
        User user = userFacade.getCurrentUser();
        System.out.println(request.getInterests());
        user.updateInterest(request.getInterests());
    }
}
