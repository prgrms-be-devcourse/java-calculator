package com.programmers.calculator.view;

import com.programmers.calculator.repository.CalculationHistory;

import java.math.BigDecimal;
import java.util.List;

public interface Output {
    void write(String message);
    void write(List<CalculationHistory> calculationHistories);
    void write(BigDecimal result);
}