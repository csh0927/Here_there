package com.example.here_there.domain.user.exception;

import com.example.here_there.global.error.CustomException;
import com.example.here_there.global.error.ErrorCode;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION = new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
