package com.example.here_there.domain.image.handler;

import com.example.here_there.domain.image.Image;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class ImageHandler {

    public Image parseFileInfo(MultipartFile multipartFile) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());

        String absolutePath = new File("").getAbsolutePath();

        String path = "/src/main/resources/static/images/" + current_date;
        File file = new File(path);

        if(!file.exists()) {
            file.mkdirs();
        }

        String contentType = multipartFile.getContentType();
        String originalFileExtension = null;

        if (contentType.contains("image/jpeg")) {
            originalFileExtension = ".jpg";
        } else if (contentType.contains("image/png")) {
            originalFileExtension = ".png";
        } else if (contentType.contains("image/gif")) {
            originalFileExtension = ".gif";
        }

        String newFileName = System.nanoTime() + originalFileExtension;

        file = new File((absolutePath + path + "/" + newFileName));
        multipartFile.transferTo(file);

        return Image.builder()
                .originalFilename(multipartFile.getOriginalFilename())
                .filePath("images/" + current_date + "/" + newFileName)
                .fileSize(multipartFile.getSize())
                .build();
    }
}
