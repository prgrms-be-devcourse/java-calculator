package com.programmers.oop.utils;

import java.util.regex.Pattern;

public class RegexUtils {

    private static final Pattern pattern = Pattern.compile("^[0-9]+$");

    private RegexUtils() {
    }

    public static boolean isNumericYn(String str) {
        return pattern.matcher(str).matches();
    }
}
