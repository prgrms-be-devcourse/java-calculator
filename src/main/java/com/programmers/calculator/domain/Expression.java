package com.programmers.calculator.domain;

import com.programmers.calculator.constant.ErrorMessage;
import com.programmers.calculator.exception.InvalidExpressionException;
import com.programmers.calculator.util.PostfixConverter;

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
        String formattedExpression = expression.replaceAll(WHITESPACE_REGEX, "");

        for (Operator operator : Operator.values()) {
            formattedExpression = formattedExpression.replace(operator.getSymbol(), operator.getFormattedSymbol());
        }
        return formattedExpression;
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
