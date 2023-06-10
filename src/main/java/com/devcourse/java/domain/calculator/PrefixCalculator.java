package com.devcourse.java.domain.calculator;

import com.devcourse.java.domain.factory.Factory;
import com.devcourse.java.domain.operator.Operator;
import com.devcourse.java.domain.parser.ExpressionParser;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.validator.Validator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PrefixCalculator implements Calculator {
    private final ExpressionParser expressionParser;
    private final Factory<Operator, String> factory;

    public PrefixCalculator(ExpressionParser expressionParser, Factory<Operator, String> factory) {
        this.expressionParser = expressionParser;
        this.factory = factory;
    }

    public CalculateResult run(String expression, Validator validator) {
        List<String> prefixExpression = expressionParser.parse(expression, validator);
        Double result = calculatePrefix(prefixExpression, validator);
        return new CalculateResult(expression, result);
    }

    private Double calculatePrefix(List<String> prefixExpression, Validator validator) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String current : prefixExpression) {
            double result = parseOrCalculate(stack, current, validator);
            stack.push(result);
        }
        return stack.pop();
    }

    private double parseOrCalculate(Deque<Double> stack, String current, Validator validator) {
        if (validator.isNumber(current)) {
            return Double.parseDouble(current);
        }
        return calculateOperands(stack, current);
    }

    private double calculateOperands(Deque<Double> stack, String current) {
        double operandY = stack.pop();
        double operandX = stack.pop();
        
        Operator operator = factory.create(current);
        return operator.operate(operandX, operandY);
    }
}
