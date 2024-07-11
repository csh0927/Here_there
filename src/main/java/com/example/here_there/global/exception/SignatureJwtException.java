package com.example.here_there.global.exception;

import com.example.here_there.global.error.CustomException;
import com.example.here_there.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new SignatureJwtException();

    private SignatureJwtException() {
        super(ErrorCode.SIGNATURE_JWT);
    }
}