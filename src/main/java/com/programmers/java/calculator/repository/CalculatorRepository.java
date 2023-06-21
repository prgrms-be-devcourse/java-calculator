package com.programmers.java.calculator.repository;

import com.programmers.java.calculator.domain.CalculationHistory;

import java.util.List;

public interface CalculatorRepository {

    void save(String expression, String result);

    List<CalculationHistory> findAll();
}
