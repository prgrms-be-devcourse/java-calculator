package com.programmers.calculator.constant;

import java.util.regex.Pattern;

public class Regex {
    public static final String regex = "\\d+|[-+*/]";
    public static final Pattern pattern = Pattern.compile(regex);
}

