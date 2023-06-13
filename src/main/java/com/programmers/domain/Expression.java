package com.programmers.domain;

import com.programmers.constant.ErrorMessage;
import com.programmers.exception.InvalidExpressionException;
import com.programmers.util.PostfixConverter;

public class Expression {
    private static final String EXPRESSION_VALIDATION_REGEX = "([0-9]+)\\s*([+\\-*/]\\s*[0-9]+\\s*)*";

    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
        validateFormat();
    }

    public String getExpression() {
        return expression;
    }

    public String toPostfix() {
        return PostfixConverter.convert(expression);
    }

    private void validateFormat() {
        if (!expression.matches(EXPRESSION_VALIDATION_REGEX)) {
            throw new InvalidExpressionException(ErrorMessage.INVALID_EXPRESSION);
        }
    }
}
