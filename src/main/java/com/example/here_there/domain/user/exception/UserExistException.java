package com.example.here_there.domain.user.exception;


import com.example.here_there.global.error.CustomException;
import com.example.here_there.global.error.ErrorCode;

public class UserExistException extends CustomException {
    public static final CustomException EXCEPTION = new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}
