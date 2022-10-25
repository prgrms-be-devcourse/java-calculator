package org.example.validate;

public class ValidateExpression implements Validate{
    private final String pattern = "[0-9](\\s[+|\\-|*|/]\\s[0-9])+";
    @Override
    public boolean isValidExpression(String expression) {
        return expression.matches(pattern);
    }
}
