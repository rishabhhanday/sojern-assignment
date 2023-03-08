package com.sojern.assignment.service.impl;

import com.sojern.assignment.model.*;
import com.sojern.assignment.service.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MathServiceImplTest {
    private MathService mathService = new MathServiceImpl();

    @Test
    void calculateMin() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11, 133, 15, 78, 1, 5));
        MinRequest minRequest = new MinRequest(numbers, 4);

        MinResponse actualMinResponse = mathService.calculateMin(minRequest);

        Assertions.assertEquals(Arrays.asList(1, 5, 11, 15), actualMinResponse.getNumbers());
    }

    @Test
    void calculateMax() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11, 133, 15, 78, 1, 5));
        MaxRequest maxRequest = new MaxRequest(numbers, 4);

        MaxResponse maxResponse = mathService.calculateMax(maxRequest);

        Assertions.assertEquals(Arrays.asList(133, 78, 22, 15), maxResponse.getNumbers());
    }

    @Test
    void calculateAverage() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11, 133, 15, 78, 1, 5));
        AvgRequest avgRequest = new AvgRequest();
        avgRequest.setNumbers(numbers);

        AvgResponse avgResponse = mathService.calculateAverage(avgRequest);

        Assertions.assertEquals(37.857142857142854, avgResponse.getAverage());
    }

    @Test
    void calculateMedian() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11, 133, 15, 78, 1, 5));
        MedianRequest medianRequest = new MedianRequest();
        medianRequest.setNumbers(numbers);

        MedianResponse medianResponse = mathService.calculateMedian(medianRequest);

        Assertions.assertEquals(15.0, medianResponse.getMedian());
    }

    @Test
    void calculatePercentile() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11, 133, 15, 78, 1, 5));
        PercentileRequest percentileRequest = new PercentileRequest();
        percentileRequest.setQuantifier(40);
        percentileRequest.setNumbers(numbers);

        PercentileResponse percentileResponse = mathService.calculatePercentile(percentileRequest);

        Assertions.assertEquals(11, percentileResponse.getPercentile());
    }
}