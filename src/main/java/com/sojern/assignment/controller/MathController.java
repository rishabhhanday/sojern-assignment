package com.sojern.assignment.controller;

import com.sojern.assignment.api.MathApi;
import com.sojern.assignment.model.*;
import com.sojern.assignment.service.AvgRequest;
import com.sojern.assignment.service.MathService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class MathController implements MathApi {
    private MathService mathService;

    @GetMapping("/min")
    @Override
    public ResponseEntity<MinResponse> calculateMinimums(@RequestParam List<Integer> numbers, @RequestParam Integer quantifier) {
        MinRequest minRequest = new MinRequest(numbers, quantifier);
        return ResponseEntity.ok(mathService.calculateMin(minRequest));
    }

    @Override
    @GetMapping("/max")
    public ResponseEntity<MaxResponse> calculateMaximums(@RequestParam List<Integer> numbers, @RequestParam Integer quantifier) {
        MaxRequest maxRequest = new MaxRequest(numbers, quantifier);
        return ResponseEntity.ok(mathService.calculateMax(maxRequest));
    }

    @Override
    @GetMapping("/avg")
    public ResponseEntity<AvgResponse> calculateAverage(@RequestParam List<Integer> numbers) {
        AvgRequest avgRequest = new AvgRequest();
        avgRequest.setNumbers(numbers);
        return ResponseEntity.ok(mathService.calculateAverage(avgRequest));
    }

    @Override
    @GetMapping("/median")
    public ResponseEntity<MedianResponse> calculateMedian(@RequestParam List<Integer> numbers) {
        MedianRequest medianRequest = new MedianRequest();
        medianRequest.setNumbers(numbers);

        return ResponseEntity.ok(mathService.calculateMedian(medianRequest));
    }
}
