package com.programmers.util;

import java.util.regex.Pattern;

public class ConstantRegex {
    private ConstantRegex() {
    }

    public static final String EXPRESSION_FILTER_REGEX = "[()+\\-*/]|\\d+";
    public static final Pattern EXPRESSION_FILTER_REGEX_COMPILE = Pattern.compile(EXPRESSION_FILTER_REGEX);
    public static final String EXPRESSION_VALIDATION_REGEX = "^[0-9+\\-*/()]*$";
    public static final Pattern EXPRESSION_VALIDATION_REGEX_COMPILE = Pattern.compile(EXPRESSION_VALIDATION_REGEX);
    public static final String WHITESPACE_REGEX = "\\s+";
}
