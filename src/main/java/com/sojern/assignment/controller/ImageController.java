package com.sojern.assignment.controller;

import com.sojern.assignment.api.ImageApi;
import com.sojern.assignment.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
@Slf4j
public class ImageController implements ImageApi {
    private ImageService imageService;

    @Override
    @GetMapping(value = "/img", produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<byte[]> getImage() {
        try {
            log.info("Returning the GIF image.");
            return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF).body(imageService.getImage());
        } catch (IOException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}
