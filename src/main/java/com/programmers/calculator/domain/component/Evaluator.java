package com.programmers.calculator.domain.component;

import com.programmers.calculator.domain.vo.CalculationResult;

import java.util.List;

public interface Evaluator {
    CalculationResult evaluate(List<String> convertedExpression);
}
