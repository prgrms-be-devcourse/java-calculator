package com.kimhunki.java.calculator.model;

import java.util.regex.Pattern;

public class RegularExpressionPattern {
    public static final Pattern operatorPattern = Pattern.compile("[+*-/]");
    public static final Pattern numberPattern = Pattern.compile("[0-9]{1,7}(\\.[0-9]{1,2})?");
    public static final Pattern acceptablePattern = Pattern.compile("^(([+*-/])|([0-9]{1,7}(\\.[0-9]{1,2})?)|\\s)+$");
    public static final Pattern pattern = Pattern.compile("([+*-/])|([0-9]{1,7}(\\.[0-9]{1,2})?)");
}
