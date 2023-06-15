package com.programmers.calculator.util;

import java.util.regex.Pattern;

public final class RegexUtils {

    private static final String regex = "\\d+|[-+*/]";
    private static final Pattern pattern = Pattern.compile(regex);

    private RegexUtils() {
        throw new RuntimeException("Regex를 인스턴스화 하지 마세요.");
    }

    public static Pattern getRegexPattern(){
        return pattern;
    }
}

