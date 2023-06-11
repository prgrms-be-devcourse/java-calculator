package org.example.domain;

import java.util.regex.Pattern;

public class Validation {

    public static final Pattern REGEX_NUM = Pattern.compile("[0-9]+");
    public static final Pattern REGEX_SELECT = Pattern.compile("[12]");
    public static final Pattern REGEX_EXPRESSION = Pattern.compile("\\d+(\\s[+\\-*/]\\s\\d+)*");
}
