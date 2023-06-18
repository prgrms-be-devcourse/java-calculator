package com.programmers.calculator;

import com.programmers.calculator.domain.CalculationResult;

import java.util.List;

public interface CalculatorRepository {
    void save(CalculationResult calculationResult);

    List<CalculationResult> findAll();
}
