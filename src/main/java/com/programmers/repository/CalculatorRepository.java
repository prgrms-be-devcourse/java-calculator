package com.programmers.repository;

import com.programmers.model.ExpressionResult;

import java.util.List;

public interface CalculatorRepository {
    int save(ExpressionResult expressionResult);
    List<ExpressionResult> findAll();
}
