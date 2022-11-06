package org.example.validate;

public class ValidateExpression implements Validate{
    private final String expressionPattern = "[0-9]+(\\s[+\\-*/]\\s[0-9]+)+";
    private final String menuPattern = "[1-3]";

    @Override
    public boolean isValidExpression(String expression) {
        return expression.matches(expressionPattern);
    }

    @Override
    public boolean isValidMenu(String input) {
        return input.matches(menuPattern);
    }
}
