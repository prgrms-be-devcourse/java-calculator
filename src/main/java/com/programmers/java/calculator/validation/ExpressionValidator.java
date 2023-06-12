package com.programmers.java.calculator.validation;

import java.util.regex.Pattern;

public class ExpressionValidator implements Validator {

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("\"^[-+*/()\\\\d\\\\s]+$\";");

    @Override
    public void validate(Object expression) {
        if (EXPRESSION_PATTERN.matcher(expression.toString()).matches()) {
            throw new IllegalArgumentException("계산할 수 없는 식입니다.");
        }
    }
}
