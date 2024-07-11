package com.example.here_there.global.exception;

import com.example.here_there.global.error.CustomException;
import com.example.here_there.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}