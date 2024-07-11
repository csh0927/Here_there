package com.example.here_there.domain.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Image {
    private String originalFilename;
    private String filePath;
    private long fileSize;
}
