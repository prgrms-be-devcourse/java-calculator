package com.programmers.util;

import java.util.regex.Pattern;

public class ConstantRegex {
    public static final String EXPRESSION_FILTER_REGEX = "[()+\\-*/]|\\d+";
    public static final Pattern EXPRESSION_FILTER_REGEX_COMPILE = Pattern.compile(EXPRESSION_FILTER_REGEX);
    public static final String EXPRESSION_VALIDATION_REGEX = "\\s+|[()+\\-*/]|\\d+";
    public static final Pattern EXPRESSION_VALIDATION_REGEX_COMPILE = Pattern.compile("\\s+|[()+\\-*/]|\\d+");
}
