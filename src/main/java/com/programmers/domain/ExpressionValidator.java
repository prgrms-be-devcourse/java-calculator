package com.programmers.domain;

import com.programmers.exception.ExpressionEmptyException;
import com.programmers.exception.ExpressionOtherCharacterException;

import java.util.regex.Pattern;

public class ExpressionValidator {

    private static final String OTHER_PATTERN = "^[+\\-*/\\d]*$";

    public String validate(String expression) {
        isEmpty(expression);
        containsOtherCharacter(expression);

        return expression;
    }

    public void isEmpty(String expression) {
        if (expression.isEmpty()) {
            throw new ExpressionEmptyException();
        }
    }

    public void containsOtherCharacter(String expression) {
        if (!Pattern.matches(OTHER_PATTERN, expression)) {
            throw new ExpressionOtherCharacterException();
        }
    }
}
