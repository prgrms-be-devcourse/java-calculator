package com.programmers.java.calculator.service;

import com.programmers.java.calculator.entity.History;

import java.util.List;

public interface CalculatorService {

    String calculate(String expression);

    List<History> getHistoryList();
}
