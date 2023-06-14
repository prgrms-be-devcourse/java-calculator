package com.programmers.java.calculator.service;

import com.programmers.java.calculator.entity.CalculationHistory;

import java.util.List;

public interface CalculatorService {

    String calculate(String expression);

    List<CalculationHistory> getHistoryList();
}
