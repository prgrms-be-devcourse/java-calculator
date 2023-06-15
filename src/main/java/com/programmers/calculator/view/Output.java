package com.programmers.calculator.view;

import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.repository.CalculationHistory;

import java.util.List;

public interface Output {
    void write(String message);
    void write(List<CalculationHistory> calculationHistories);
    void write(CalculationResult result);
}