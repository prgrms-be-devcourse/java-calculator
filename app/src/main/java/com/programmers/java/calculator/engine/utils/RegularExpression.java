package com.programmers.java.calculator.engine.utils;

import java.util.regex.Pattern;

public class RegularExpression {
    private RegularExpression() {
    }

    public static boolean isSum (String str) {
        return Pattern.matches("[\\+\\-]", str);
    }

    public static boolean isMulti (String str) {
        return Pattern.matches("[\\*\\/]", str);
    }

    public static boolean isNumeric (String str) {
        return Pattern.matches("^(-?[0-9]+)$", str);
    }

    public static boolean isOperator (String str) {
        return Pattern.matches("[\\+\\-\\*\\/]", str);
    }
}
