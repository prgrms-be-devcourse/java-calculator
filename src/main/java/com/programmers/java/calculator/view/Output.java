package com.programmers.java.calculator.view;

import com.programmers.java.calculator.dto.CalculationHistory;

import java.util.List;

public interface Output {

    void printError(String message);

    void printResult(String message);

    void printHistoryList(List<CalculationHistory> history);
}
