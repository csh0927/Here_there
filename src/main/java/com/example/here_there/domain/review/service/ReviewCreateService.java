package com.example.here_there.domain.review.service;

import com.example.here_there.domain.image.Image;
import com.example.here_there.domain.image.handler.ImageHandler;
import com.example.here_there.domain.review.domain.Review;
import com.example.here_there.domain.review.domain.repository.ReviewRepository;
import com.example.here_there.domain.review.presentation.dto.request.ReviewCreateRequest;
import com.example.here_there.domain.user.domain.User;
import com.example.here_there.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReviewCreateService {
    private final ReviewRepository reviewRepository;
    private final ImageHandler imageHandler;
    private final UserFacade userFacade;

    @Transactional
    public void execute(MultipartFile file, ReviewCreateRequest request) throws Exception {
        User user = userFacade.getCurrentUser();

        Image image = imageHandler.parseFileInfo(file);

        reviewRepository.save(Review.builder()
                .title(request.getTitle())
                .country(request.getCountry())
                .region(request.getRegion())
                .interests(request.getInterests())
                .address(request.getAddress())
                .content(request.getContent())
                .user(user)
                .createDate(LocalDateTime.now())
                .originalFileName(image.getOriginalFilename())
                .storedFileName(image.getFilePath())
                .fileSize(image.getFileSize())
                .build());
    }
}
