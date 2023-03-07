package com.sojern.assignment.api;

import org.springframework.http.ResponseEntity;

public interface ImageApi {
    ResponseEntity<byte[]> getImage();
}
