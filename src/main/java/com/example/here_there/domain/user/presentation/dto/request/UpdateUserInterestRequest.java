package com.example.here_there.domain.user.presentation.dto.request;

import com.example.here_there.domain.user.domain.Interest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class UpdateUserInterestRequest {
    private List<Interest> interests;
}
