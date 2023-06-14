package com.programmers.calculator.util;

import java.util.regex.Pattern;

public class Regex {
    public static final String regex = "\\d+|[-+*/]";
    public static final Pattern pattern = Pattern.compile(regex);
}

