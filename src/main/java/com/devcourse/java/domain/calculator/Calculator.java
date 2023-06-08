package com.devcourse.java.domain.calculator;

import com.devcourse.java.domain.parser.ExpressionParser;
import com.devcourse.java.domain.storage.CalculateResult;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {
    private final ExpressionParser expressionParser;

    public Calculator(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public CalculateResult run(String expression) {
        List<String> prefixExpression = expressionParser.parse(expression);

        Deque<Integer> stack = new ArrayDeque<>();


        return new CalculateResult(expression, 1);
    }
}
