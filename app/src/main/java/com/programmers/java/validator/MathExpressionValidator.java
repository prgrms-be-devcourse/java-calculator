package com.programmers.java.validator;

import static com.programmers.java.pattern.RegexPattern.MATH_EXPRESSION;

public class MathExpressionValidator implements InputValidator {
    @Override
    public boolean validate(String input) {
        return input.replaceAll("\\s", "")
                .matches(MATH_EXPRESSION.getPattern());
    }

    @Override
    public void printErrorMessage() {
        System.out.println("잘못된 수식입니다");
    }
}
