package com.devcourse.java.domain.calculator;

import com.devcourse.java.domain.calculateResult.CalculateResult;
import com.devcourse.java.domain.parser.ExpressionParser;

import java.util.List;

public class Calculator {
    private final ExpressionParser expressionParser;

    public Calculator(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public CalculateResult run(String expression) {
        List<Character> prefixExpression = expressionParser.parse(expression);
        return new CalculateResult(expression, 1);
    }
}
