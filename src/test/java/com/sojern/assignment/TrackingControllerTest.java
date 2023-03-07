package com.sojern.assignment;

import com.sojern.assignment.controller.TrackingController;
import com.sojern.assignment.model.PingResponse;
import com.sojern.assignment.service.PingService;
import com.sojern.assignment.service.impl.PingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class TrackingControllerTest {
    @Autowired
    private TrackingController trackingController;

    @Test
    public void testPing() {
        ResponseEntity<PingResponse> ping = trackingController.ping();

        Assertions.assertEquals(200, ping.getStatusCodeValue());
        Assertions.assertEquals("OK", ping.getBody().getStatus());
    }

    @Test
    public void testServiceUnavailable() {
        Resource resource = new ClassPathResource("temp/ok_missing.txt");
        PingService pingService = new PingServiceImpl(resource);
        TrackingController pingController = new TrackingController(pingService);

        ResponseEntity<PingResponse> ping = pingController.ping();

        Assertions.assertEquals(503, ping.getStatusCodeValue());
    }
}
