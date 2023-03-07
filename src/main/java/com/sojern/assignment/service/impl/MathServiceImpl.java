package com.sojern.assignment.service.impl;

import com.sojern.assignment.exception.InvalidMinRequestException;
import com.sojern.assignment.model.MinRequest;
import com.sojern.assignment.model.MinResponse;
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

        sort(numbers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()), Integer::compareTo);

        List<Integer> minNumbers = new ArrayList<>();
        for (int i = 0; i < minRequest.getQuantifier(); i++) {
            minNumbers.add(numbers.get(i));
        }

        MinResponse minResponse = new MinResponse();
        minResponse.setNumbers(minNumbers);

        return minResponse;
    }

    private void sort(List<Integer> numbers, Comparator<Integer> comparator) {
        numbers.sort(comparator);
    }


    private void validate(List<Integer> numbers, Integer quantifier) {
        if (numbers.isEmpty()) {
            throw new InvalidMinRequestException("Numbers cannot be empty");
        } else if (quantifier > numbers.size()) {
            throw new InvalidMinRequestException("Quantifier must be less than or equals to numbers size.");
        }
    }
}
