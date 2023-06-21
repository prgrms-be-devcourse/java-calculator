package com.programmers.domain;

import com.programmers.error.CalculatorException;

import java.util.function.BinaryOperator;

import static com.programmers.error.ErrorMessage.DIVIDE_ZERO_EXCEPTION;
import static com.programmers.error.ErrorMessage.INVALID_OPERATOR_EXCEPTION;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0) throw new CalculatorException(DIVIDE_ZERO_EXCEPTION);
        return num1 / num2;
    });

    private final String operator;
    private final BinaryOperator<Integer> expression;

    Operator(String operator, BinaryOperator<Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator getOperator(String operator) {
        switch (operator) {
            case "+":
                return PLUS;
            case "-":
                return MINUS;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new CalculatorException(INVALID_OPERATOR_EXCEPTION);
        }
    }

    public static boolean isHigherPriority(Operator operator) {
        if (operator == MULTIPLY || operator == DIVIDE) {
            return true;
        } else {
            return false;
        }
    }

    public int applyOperation(int num1, int num2) {
        return expression.apply(num1, num2);
    }

}
