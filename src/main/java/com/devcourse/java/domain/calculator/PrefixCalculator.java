package com.devcourse.java.domain.calculator;

import com.devcourse.java.common.Validator;
import com.devcourse.java.domain.factory.Factory;
import com.devcourse.java.domain.operator.Operator;
import com.devcourse.java.domain.calculator.parser.PrefixParser;
import com.devcourse.java.domain.storage.CalculateResult;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PrefixCalculator implements Calculator {
    private final PrefixParser parser;
    private final Factory<Operator, String> factory;

    public PrefixCalculator(PrefixParser parser, Factory<Operator, String> factory) {
        this.parser = parser;
        this.factory = factory;
    }

    public CalculateResult run(String expression) {
        List<String> prefixExpression = parser.parse(expression);
        Double result = calculatePrefix(prefixExpression);
        return new CalculateResult(expression, result);
    }

    private Double calculatePrefix(List<String> prefixExpression) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String current : prefixExpression) {
            double result = parseOrCalculate(stack, current);
            stack.push(result);
        }
        return stack.pop();
    }

    private double parseOrCalculate(Deque<Double> stack, String current) {
        if (Validator.isNumber(current)) {
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
