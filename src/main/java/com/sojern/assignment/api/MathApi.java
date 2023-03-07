package com.sojern.assignment.api;

import com.sojern.assignment.model.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MathApi {
    ResponseEntity<MinResponse> calculateMinimums(List<Integer> numbers, Integer quantifier);

    ResponseEntity<MaxResponse> calculateMaximums(List<Integer> numbers, Integer quantifier);

    ResponseEntity<AvgResponse> calculateAverage(List<Integer> numbers);

    ResponseEntity<MedianResponse> calculateMedian(List<Integer> numbers);

    ResponseEntity<PercentileResponse> calculatePercentile(List<Integer> numbers, Integer quantifier);
}
