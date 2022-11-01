package com.programmers.devcourse.validation;

public class Validator {
    private static class LazyHolder {
        private static final Validator INSTANCE = new Validator();
    }

    public static Validator getInstance() {
        return LazyHolder.INSTANCE;
    }

    public boolean validate(String input) {
        return (this.isNotBlank(input) && this.isValidToken(input));
    }

    public boolean isNotBlank(String input) {
        boolean isEmpty = input.isEmpty();
        if (isEmpty) {
            System.out.println(ValidationMessage.EMPTY.getMessageStr());
        }
        return !isEmpty;
    }

    public boolean isValidToken(String input) {
        boolean isNumberOrOperatorOrParentheses = input.matches("^[()\\d\\s+\\-*/]*$");
        if (!isNumberOrOperatorOrParentheses) {
            System.out.println(ValidationMessage.NOT_VALID_TOKEN.getMessageStr());
        }
        return isNumberOrOperatorOrParentheses;
    }

    public boolean isNumber(String input) {
        return input.matches("\\d+");
    }

    public boolean isNumber(char input) {
        return isNumber(String.valueOf(input));
    }


}
