package com.programmers.calculator.util;

import java.util.regex.Pattern;

public final class Regex {

    private Regex() {
        throw new RuntimeException("Regex를 생성하지 마세요.");
    }

    public static final String regex = "\\d+|[-+*/]";
    public static final Pattern pattern = Pattern.compile(regex);
}

