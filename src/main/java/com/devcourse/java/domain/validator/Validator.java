package com.devcourse.java.domain.validator;

import com.devcourse.java.domain.console.Console;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.devcourse.java.common.Messages.BAD_EXPRESSION;
import static com.devcourse.java.common.Messages.EMPTY_STORAGE;

public class Validator {
    private static final Pattern VALID_EXPRESSION = Pattern.compile("^\\s*-?\\d+(\\.\\d+)?(\\s*[-+*/]\\s*-?\\d+(\\.\\d+)?)*\\s*$");
    public Validator() { }

    public boolean isNotEmpty(List target, Console console) {
        if (target.isEmpty()) {
            console.print(EMPTY_STORAGE.toMessage());
            return false;
        }
        return true;
    }

    public boolean isValidExpression(String expression, Console console) {
        if (validateExpression(expression)) {
            return true;
        }
        console.print(BAD_EXPRESSION.toMessage());
        return false;
    }

    public boolean isNumber(String character) {
        try {
            Integer.parseInt(character);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean validateExpression(String expression) {
        Matcher matcher = VALID_EXPRESSION.matcher(expression);
        return isNotBlank(expression) && matcher.matches();
    }

    private boolean isNotBlank(String expression) {
        return StringUtils.isNotBlank(expression);
    }
}
