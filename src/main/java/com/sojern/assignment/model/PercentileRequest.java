package com.sojern.assignment.model;

import lombok.Data;

import java.util.List;

@Data
public class PercentileRequest {
    private List<Integer> numbers;
    private Integer quantifier;
}
