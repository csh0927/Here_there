package com.example.here_there.domain.user.exception;

import com.example.here_there.global.error.CustomException;
import com.example.here_there.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
