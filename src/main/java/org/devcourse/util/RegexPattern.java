package org.devcourse.util;

import java.util.regex.Pattern;

public class RegexPattern {

    public static final Pattern EXPRESSION_PATTERN = Pattern.compile("^[\\.+\\-*/\\(\\)\\d]*$");
    public static final Pattern OPERAND_PATTERN = Pattern.compile("[0-9\\(\\)\\.]");
    public static final Pattern NOT_OPERAND_PATTERN = Pattern.compile("[0-9]\\(|\\)[0-9]");
    public static final Pattern OPERATOR_PATTERN = Pattern.compile("^[+\\-*/\\(\\)]*$");


}
