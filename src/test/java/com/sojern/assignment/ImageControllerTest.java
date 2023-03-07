package com.sojern.assignment;

import com.sojern.assignment.controller.ImageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ImageControllerTest {
    @Autowired
    private ImageController imageController;

    @Test
    public void testImageApi() {
        ResponseEntity<byte[]> actualResponse = imageController.getImage();

        Assertions.assertEquals(200, actualResponse.getStatusCodeValue());
        Assertions.assertEquals(MediaType.IMAGE_GIF, actualResponse.getHeaders().getContentType());
        Assertions.assertNotNull(actualResponse.getBody());
    }
}
