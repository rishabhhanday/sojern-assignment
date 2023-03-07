package com.sojern.assignment.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class MaxRequest {
    @NotNull
    private List<Integer> numbers;
    @NotNull
    private Integer quantifier;
}
