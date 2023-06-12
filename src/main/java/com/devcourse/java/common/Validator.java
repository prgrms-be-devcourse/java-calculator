package com.devcourse.java.common;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern VALID_EXPRESSION = Pattern.compile("^\\s*-?\\d+(\\.\\d+)?(\\s*[-+*/]\\s*-?\\d+(\\.\\d+)?)*\\s*$");
    private Validator() { }

    public static boolean isNotEmpty(Collection target) {
        return !target.isEmpty();
    }

    public static boolean isValidExpression(String expression) {
        return validateExpression(expression);
    }

    public static boolean isNumber(String character) {
        try {
            Integer.parseInt(character);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static boolean validateExpression(String expression) {
        Matcher matcher = VALID_EXPRESSION.matcher(expression);
        return isNotBlank(expression) && matcher.matches();
    }

    private static boolean isNotBlank(String expression) {
        return StringUtils.isNotBlank(expression);
    }
}
