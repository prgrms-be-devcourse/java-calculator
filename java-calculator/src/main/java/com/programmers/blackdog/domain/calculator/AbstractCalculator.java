package com.programmers.blackdog.domain.calculator;

import com.programmers.blackdog.domain.expression.Expression;

public interface AbstractCalculator {
    int calculate(Expression expression);
}
