package com.programmers.junho.domain.utils;

public class StringUtil {

    private StringUtil() {
        throw new AssertionError("Util 클래스 생성 불가합니다.");
    }

    public static int convertStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수형 범위를 초과했습니다");
        }
    }
}
