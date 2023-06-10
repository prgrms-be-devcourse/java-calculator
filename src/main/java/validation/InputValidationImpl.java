package validation;

import exception.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidationImpl implements InputValidation{
    private static final Pattern BUTTON_PATTERN = Pattern.compile("^[1-2]$");
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("^[0-9]+(\\s[+\\-*/]\\s[0-9]+)+$");

    @Override
    public boolean validateButton(String input) {
        if (!BUTTON_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_BUTTON_NOT_RANGE.getMessage());
        }
        return true;
    }

    @Override
    public boolean validateExpression(String expression) {
        if (!EXPRESSION_PATTERN.matcher(expression).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_EXPRESSION.getMessage());
        }
        return false;
    }
}
