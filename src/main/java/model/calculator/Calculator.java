package model.calculator;

import controller.dto.MathExpression;

public interface Calculator {
    int calculate(final MathExpression me);
}
