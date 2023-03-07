package com.sojern.assignment.service.impl;

import com.sojern.assignment.exception.InvalidRequestException;
import com.sojern.assignment.model.*;
import com.sojern.assignment.service.AvgRequest;
import com.sojern.assignment.service.MathService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MathServiceImpl implements MathService {
    @Override
    public MinResponse calculateMin(MinRequest minRequest) {
        validate(minRequest.getNumbers(), minRequest.getQuantifier());

        List<Integer> numbers = minRequest.getNumbers();

        numbers = numbers.stream().filter(Objects::nonNull).collect(Collectors.toList());
        numbers.sort(Integer::compareTo);

        List<Integer> minNumbers = new ArrayList<>();
        for (int i = 0; i < minRequest.getQuantifier(); i++) {
            minNumbers.add(numbers.get(i));
        }

        MinResponse minResponse = new MinResponse();
        minResponse.setNumbers(minNumbers);

        return minResponse;
    }

    @Override
    public MaxResponse calculateMax(MaxRequest maxRequest) {
        validate(maxRequest.getNumbers(), maxRequest.getQuantifier());

        List<Integer> numbers = maxRequest.getNumbers();
        numbers = numbers.stream().filter(Objects::nonNull).collect(Collectors.toList());
        numbers.sort(Comparator.reverseOrder());

        List<Integer> minNumbers = new ArrayList<>();
        for (int i = 0; i < maxRequest.getQuantifier(); i++) {
            minNumbers.add(numbers.get(i));
        }

        MaxResponse maxResponse = new MaxResponse();
        maxResponse.setNumbers(minNumbers);

        return maxResponse;
    }

    @Override
    public AvgResponse calculateAverage(AvgRequest avgRequest) {
        validate(avgRequest.getNumbers());

        Integer sum = avgRequest.getNumbers().stream().reduce(0, Integer::sum);
        Double avg = (sum / (double) avgRequest.getNumbers().size());

        AvgResponse avgResponse = new AvgResponse();
        avgResponse.setAverage(avg);
        return avgResponse;
    }


    private void validate(List<Integer> numbers, Integer quantifier) {
        if (numbers.isEmpty()) {
            throw new InvalidRequestException("Numbers cannot be empty");
        } else if (quantifier > numbers.size()) {
            throw new InvalidRequestException("Quantifier must be less than or equals to numbers size.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new InvalidRequestException("Numbers cannot be empty");
        }
    }
}
