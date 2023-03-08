package com.sojern.assignment.service.impl;

import com.sojern.assignment.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {
    private final String imagePath;

    public ImageServiceImpl(@Value("${image.path}") String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    @Cacheable("img_cache")
    public byte[] getImage() throws IOException {
        Resource resource = new ClassPathResource(imagePath);
        InputStream inputStream = resource.getInputStream();
        byte[] b = new byte[inputStream.available()];
        while (inputStream.available() != 0) {
            inputStream.read(b);
        }

        log.info("Generating image bytes and caching it.");
        return b;
    }
}
