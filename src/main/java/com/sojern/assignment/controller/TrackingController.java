package com.sojern.assignment.controller;

import com.sojern.assignment.api.TrackingApi;
import com.sojern.assignment.model.PingResponse;
import com.sojern.assignment.service.PingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class TrackingController implements TrackingApi {
    private PingService pingService;

    @Override
    @GetMapping("/ping")
    public ResponseEntity<PingResponse> ping() {
        Optional<PingResponse> ping = pingService.ping();
        return ping.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(503).build());
    }
}
