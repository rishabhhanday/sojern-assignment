package com.sojern.assignment.service.impl;

import com.sojern.assignment.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;

@Service
public class ImageServiceImpl implements ImageService {
    private Resource resource;

    public ImageServiceImpl(@Value("classpath:/temp/assignment.gif") Resource resource) {
        this.resource = resource;
    }

    @Override
    public byte[] getImage() throws IOException {
        return Files.readAllBytes(resource.getFile().toPath());
    }
}
