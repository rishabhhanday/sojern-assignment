package com.sojern.assignment.controller;

import com.sojern.assignment.api.MathApi;
import com.sojern.assignment.model.MinRequest;
import com.sojern.assignment.model.MinResponse;
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
}
