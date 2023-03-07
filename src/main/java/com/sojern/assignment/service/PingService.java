package com.sojern.assignment.service;

import com.sojern.assignment.model.PingResponse;

import java.util.Optional;

public interface PingService {
    public Optional<PingResponse> ping();
}
