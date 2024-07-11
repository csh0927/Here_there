package com.example.here_there.domain.review.presentation;


import com.example.here_there.domain.review.presentation.dto.request.ReviewCreateRequest;
import com.example.here_there.domain.review.presentation.dto.response.ReviewDetailsResponse;
import com.example.here_there.domain.review.presentation.dto.response.ReviewListResponse;
import com.example.here_there.domain.review.service.MyReviewService;
import com.example.here_there.domain.review.service.RecommendReviewService;
import com.example.here_there.domain.review.service.ReviewCreateService;
import com.example.here_there.domain.review.service.ReviewDeleteService;
import com.example.here_there.domain.review.service.ReviewDetailsService;
import com.example.here_there.domain.review.service.SearchReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/review")
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewCreateService reviewCreateService;
    private final ReviewDetailsService reviewDetailsService;
    private final ReviewDeleteService reviewDeleteService;
    private final MyReviewService myReviewService;
    private final SearchReviewService searchReviewService;
    private final RecommendReviewService recommendReviewService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void reviewCreate(@RequestPart(value = "file", required = false) MultipartFile file, @RequestPart(value = "data") ReviewCreateRequest request) throws Exception{
        reviewCreateService.execute(file, request);
    }

    @DeleteMapping("/{id}")
    public void reviewDelete(@PathVariable("id") Long boardId){
        reviewDeleteService.execute(boardId);
    }

    @GetMapping("/{id}")
    public ReviewDetailsResponse reviewDetails(@PathVariable("id") Long reviewId) {
        return reviewDetailsService.execute(reviewId);
    }

    @GetMapping
    public List<ReviewListResponse> myReview() {
        return myReviewService.execute();
    }

    @GetMapping("/search")
    public List<ReviewListResponse> searchReview(@RequestParam String keyword) {
        return searchReviewService.execute(keyword);
    }

    @GetMapping("/recommend")
    public List<ReviewListResponse> recommendReview() {
        return recommendReviewService.execute();
    }
}
