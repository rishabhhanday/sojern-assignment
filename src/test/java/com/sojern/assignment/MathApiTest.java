package com.sojern.assignment;

import com.sojern.assignment.api.MathApi;
import com.sojern.assignment.exception.InvalidRequestException;
import com.sojern.assignment.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MathApiTest {
    @Autowired
    private MathApi mathApi;

    @Test
    public void testMinApi() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11, 78, 1, 5));
        Integer quantifier = 3;
        ResponseEntity<MinResponse> actualResponse = mathApi.calculateMinimums(numbers, quantifier);

        Assertions.assertEquals(200, actualResponse.getStatusCodeValue());
        Assertions.assertEquals(Arrays.asList(1, 5, 11), actualResponse.getBody().getNumbers());
    }

    @Test
    public void testMaxApi() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11, 78, 1, 5));
        Integer quantifier = 3;
        ResponseEntity<MaxResponse> actualResponse = mathApi.calculateMaximums(numbers, quantifier);

        Assertions.assertEquals(200, actualResponse.getStatusCodeValue());
        Assertions.assertEquals(Arrays.asList(78, 22, 11), actualResponse.getBody().getNumbers());
    }

    @Test
    public void testAvgApi() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11));
        ResponseEntity<AvgResponse> actualResponse = mathApi.calculateAverage(numbers);

        Assertions.assertEquals(200, actualResponse.getStatusCodeValue());
        Assertions.assertEquals(16.5, actualResponse.getBody().getAverage());
    }

    @Test
    public void testMedianApi() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2));
        ResponseEntity<MedianResponse> actualResponse = mathApi.calculateMedian(numbers);

        Assertions.assertEquals(200, actualResponse.getStatusCodeValue());
        Assertions.assertEquals(1.5, actualResponse.getBody().getMedian());
    }

    @Test
    public void testPercentileApi() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(12,15,17,18,26,34,57,65,68,69));
        Integer quantifier = 25;
        ResponseEntity<PercentileResponse> actualResponse = mathApi.calculatePercentile(numbers, quantifier);

        Assertions.assertEquals(200, actualResponse.getStatusCodeValue());
        Assertions.assertEquals(17, actualResponse.getBody().getPercentile());
    }

    @Test
    public void testMinApiForInvalidQuantifier() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11, 78, 1, 5));
        Integer quantifier = 99;

        Assertions.assertThrows(InvalidRequestException.class, () -> mathApi.calculateMaximums(numbers, quantifier));
    }
}
