package com.sojern.assignment.api;

import com.sojern.assignment.model.PingResponse;
import org.springframework.http.ResponseEntity;

public interface TrackingApi {
    ResponseEntity<PingResponse> ping();
}
