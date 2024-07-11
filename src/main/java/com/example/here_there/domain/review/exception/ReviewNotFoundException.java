package com.example.here_there.domain.review.exception;

import com.example.here_there.global.error.CustomException;
import com.example.here_there.global.error.ErrorCode;

public class ReviewNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new ReviewNotFoundException();

    private ReviewNotFoundException() {
        super(ErrorCode.REVIEW_NOT_FOUND);
    }
}
