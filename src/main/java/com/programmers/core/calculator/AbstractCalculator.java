package com.programmers.core.calculator;

import com.programmers.core.data.CalculationRequest;
import com.programmers.core.data.CalculationResult;

public interface AbstractCalculator {
    CalculationResult calculate(CalculationRequest request);
}