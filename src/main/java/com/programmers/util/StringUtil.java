package com.programmers.util;

public final class StringUtil {
    private StringUtil() {
        throw new AssertionError("StringUtil 클래스는 인스턴스화 할 수 없습니다.");
    }

    private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";

    public static boolean isNumber(String unCheckedToken) {
        if (unCheckedToken == null) {
            throw new IllegalArgumentException();
        }

        return unCheckedToken.matches(NUMBER_REGEX);
    }

    public static long convertStringToLong(String token) {
        return Long.parseLong(token);
    }
}
