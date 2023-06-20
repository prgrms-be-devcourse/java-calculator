package com.programmers.calculator.domain.core;

import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.domain.vo.Expression;

public interface Calculator {
    CalculationResult calculate(Expression expression);
}
