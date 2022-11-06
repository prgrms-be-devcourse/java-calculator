package com.programmers.java.validator;

import static com.programmers.java.pattern.RegexPattern.*;

public class FormValidator implements InputValidator {
    @Override
    public boolean validate(String input) {
        for (String token : input.split(" ")) {
            if (isNotValidToken(token)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotValidToken(String token) {
        return !token.matches("^(" + OPERATOR.getPattern() + "|" + NUMBER.getPattern() + "|" + "[()]+" + ")$");
    }

    @Override
    public void printErrorMessage() {
        System.out.println("잘못된 형식의 입력입니다.");
    }
}
