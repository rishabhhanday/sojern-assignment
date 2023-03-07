package com.sojern.assignment.service.impl;

import com.sojern.assignment.model.PingResponse;
import com.sojern.assignment.service.PingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PingServiceImpl implements PingService {

    private Resource resource;

    public PingServiceImpl(@Value("classpath:temp/ok.txt") Resource resource) {
        this.resource = resource;
    }

    @Override
    public Optional<PingResponse> ping() {
        if (resource.exists()) {
            PingResponse pingResponse = new PingResponse();
            pingResponse.setStatus("OK");

            return Optional.of(pingResponse);
        }

        return Optional.empty();
    }
}
