package com.example.here_there.global.exception;

import com.example.here_there.global.error.CustomException;
import com.example.here_there.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {
    public static final CustomException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}