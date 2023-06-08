package com.devcourse.java.domain.calculator;

import com.devcourse.java.common.Factory;
import com.devcourse.java.domain.operator.Operator;
import com.devcourse.java.domain.parser.ExpressionParser;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.validator.Validator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {
    private final ExpressionParser expressionParser;
    private final Factory<Operator, String> factory;

    public Calculator(ExpressionParser expressionParser, Factory<Operator, String> factory) {
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
            if (validator.isNumber(current)) {
                pushOperand(stack, current);
                continue;
            }
            calculateOperands(stack, current);
        }
        return stack.pop();
    }

    private void pushOperand(Deque<Double> stack, String current) {
        double parsed = Double.parseDouble(current);
        stack.push(parsed);
    }

    private void calculateOperands(Deque<Double> stack, String current) {
        double operandY = stack.pop();
        double operandX = stack.pop();
        
        Operator operator = factory.create(current);
        double result = operator.operate(operandX, operandY);
        stack.push(result);
    }
}
