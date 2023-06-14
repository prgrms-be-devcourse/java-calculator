package com.programmers.java.calculator.io;

import com.programmers.java.calculator.entity.CalculationHistory;

import java.util.List;

public interface Output {

    void inputError(String message);

    void print(String message);

    void printHistoryList(List<CalculationHistory> history);
}
