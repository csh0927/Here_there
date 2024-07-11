package com.example.here_there.domain.user.service;

import com.example.here_there.domain.image.Image;
import com.example.here_there.domain.image.handler.ImageHandler;
import com.example.here_there.domain.user.domain.User;
import com.example.here_there.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UpdateUserImageService {
    private final UserFacade userFacade;
    private final ImageHandler imageHandler;

    @Transactional
    public void execute(MultipartFile file) throws Exception {
        User user = userFacade.getCurrentUser();

        Image image = imageHandler.parseFileInfo(file);

        user.uploadImages(image.getOriginalFilename(), image.getFilePath(), image.getFileSize());
    }
}
