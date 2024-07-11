package com.example.here_there.domain.review.exception;


import com.example.here_there.global.error.CustomException;
import com.example.here_there.global.error.ErrorCode;

public class WriterMismatchedException extends CustomException {
    public static final CustomException EXCEPTION =
            new WriterMismatchedException();

    private WriterMismatchedException() {
        super(ErrorCode.WRITER_MISMATCH);
    }
}
