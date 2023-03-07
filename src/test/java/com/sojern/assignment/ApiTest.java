package com.sojern.assignment;

import com.sojern.assignment.api.MathApi;
import com.sojern.assignment.exception.InvalidMinRequestException;
import com.sojern.assignment.model.MaxResponse;
import com.sojern.assignment.model.MinResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ApiTest {
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
    public void testMinApiForInvalidQuantifier() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(22, 11, 78, 1, 5));
        Integer quantifier = 99;

        Assertions.assertThrows(InvalidMinRequestException.class, () -> mathApi.calculateMaximums(numbers, quantifier));
    }
}
