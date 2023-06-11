package com.programmers.calculator;

import com.programmers.converter.ExpressionConverter;
import com.programmers.converter.Operator;
import com.programmers.converter.ResultConverter;
import com.programmers.io.Console;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class Accumulator {

    private final ExpressionConverter expressionConverter;

    public Accumulator(ExpressionConverter expressionConverter) {
        this.expressionConverter = expressionConverter;
    }

    public Optional<String> calculate(String expression) {
        Optional<String> result = Optional.empty();
        try {
            List<String> convert = expressionConverter.convert(expression);
            BigDecimal calc = getComputationResult(convert).stripTrailingZeros();
            result = Optional.of(ResultConverter.convertResult(calc.toString()));
        } catch (IllegalArgumentException | ArithmeticException e) {
            Console.printError(e.getMessage());
        }
        return result;
    }

    private BigDecimal getComputationResult(List<String> convert) {
        Deque<BigDecimal> stack = new ArrayDeque<>();

        convert.forEach(op -> {
            if (Operator.isOperator(op)) {
                Operator operator = Operator.getOperation(op);
                BigDecimal n2 = stack.pop();
                BigDecimal n1 = stack.pop();
                stack.push(operator.operation(n1, n2));
            }

            if (!Operator.isOperator(op)) {
                stack.push(BigDecimal.valueOf(Double.parseDouble(op)));
            }
        });
        return stack.pop();
    }

}
