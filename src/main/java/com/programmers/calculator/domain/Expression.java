package com.programmers.calculator.domain;

import com.programmers.calculator.constant.ErrorMessage;
import com.programmers.calculator.exception.InvalidExpressionException;
import com.programmers.calculator.util.PostfixConverter;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class Expression {
    private static final String WHITESPACE_REGEX = "\\s+";
    private static final String EXPRESSION_VALIDATION_REGEX = "([0-9]+)\\s*([+\\-*/]\\s*[0-9]+\\s*)*";

    private final String expression;

    public Expression(String expression) {
        this.expression = formatExpression(expression);
        validateWrongFormat();
        validateDivisionByZero();
    }

    public String getExpression() {
        return expression;
    }

    public String toPostfix() {
        return PostfixConverter.convert(expression);
    }

    private String formatExpression(String expression) {
        return Arrays.stream(expression.split(WHITESPACE_REGEX))
                .map(this::replaceFormattedOperator)
                .collect(joining());
    }

    private String replaceFormattedOperator(String token) {
        for (Operator operator : Operator.values()) {
            token = token.replace(operator.getSymbol(), operator.getFormattedSymbol());
        }
        return token;
    }

    private void validateWrongFormat() {
        if (!expression.matches(EXPRESSION_VALIDATION_REGEX)) {
            throw new InvalidExpressionException(ErrorMessage.INVALID_EXPRESSION);
        }
    }

    private void validateDivisionByZero() {
        if (expression.contains("/ 0")) {
            throw new InvalidExpressionException(ErrorMessage.DIVISION_BY_ZERO);
        }
    }
}
