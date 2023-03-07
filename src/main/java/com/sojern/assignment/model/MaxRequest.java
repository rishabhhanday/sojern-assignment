package com.sojern.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MaxRequest {

    private List<Integer> numbers;
    private Integer quantifier;
}
