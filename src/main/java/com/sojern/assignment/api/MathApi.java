package com.sojern.assignment.api;

import com.sojern.assignment.model.AvgResponse;
import com.sojern.assignment.model.MaxResponse;
import com.sojern.assignment.model.MinResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MathApi {
    ResponseEntity<MinResponse> calculateMinimums(List<Integer> numbers, Integer quantifier);

    ResponseEntity<MaxResponse> calculateMaximums(List<Integer> numbers, Integer quantifier);

    ResponseEntity<AvgResponse> calculateAverage(List<Integer> numbers);
}
