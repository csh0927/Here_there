package com.example.here_there.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {
    @NotNull
    private String nickname;

    @Email(message = "email 형식에 맞춰주세요")
    private String email;
}
