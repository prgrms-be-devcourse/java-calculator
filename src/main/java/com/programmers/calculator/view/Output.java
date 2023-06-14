package com.programmers.calculator.view;

import com.programmers.calculator.repository.CalculationHistory;

import java.math.BigDecimal;
import java.util.List;

public interface Output {
    void outputOption();
    void outputExit();
    void outputHistory(List<CalculationHistory> calculationHistories);
    void outputCalculation(BigDecimal result);
}