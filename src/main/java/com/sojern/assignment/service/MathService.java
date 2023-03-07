package com.sojern.assignment.service;

import com.sojern.assignment.model.MaxRequest;
import com.sojern.assignment.model.MaxResponse;
import com.sojern.assignment.model.MinRequest;
import com.sojern.assignment.model.MinResponse;

public interface MathService {
    MinResponse calculateMin(MinRequest minRequest);
    MaxResponse calculateMax(MaxRequest maxRequest);
}
