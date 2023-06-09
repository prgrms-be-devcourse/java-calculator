package com.programmers.calculator;

import com.programmers.converter.ExpressionConverter;
import com.programmers.converter.Operator;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Accumulator {

    private final ExpressionConverter expressionConverter;

    public Accumulator(ExpressionConverter expressionConverter) {
        this.expressionConverter = expressionConverter;
    }

    public String compute(String expression) {
        List<String> convert = expressionConverter.convert(expression);
        BigDecimal calc = calculate(convert).stripTrailingZeros();
        return convertResultValue(calc.toString());

    }

    private BigDecimal calculate(List<String> convert) {
        Deque<BigDecimal> stack = new ArrayDeque<>();
        for (String op : convert) {
            if (Operator.isOperator(op)) {
                Operator operator = Operator.getOperation(op);
                BigDecimal n2 = stack.pop();
                BigDecimal n1 = stack.pop();
                stack.push(operator.operation(n1, n2));
                continue;
            }
            stack.push(BigDecimal.valueOf(Double.parseDouble(op)));
        }
        return stack.pop();
    }

    private String convertResultValue(String calc) {
        int commaIndex = calc.indexOf('.');

        if (isDecimalPlaceOverTen(calc, commaIndex))
            return calc.substring(0, commaIndex + 11);
        return calc;
    }

    private boolean isDecimalPlaceOverTen(String calc, int commaIndex) {
        int decimalPlace = calc.substring(commaIndex + 1).length();
        return decimalPlace >= 10;
    }
}
