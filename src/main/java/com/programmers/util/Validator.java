package com.programmers.util;

public final class Validator {
    private Validator() {
        throw new AssertionError("Validator 클래스는 인스턴스화 할 수 없습니다.");
    }

    public static boolean isOperatorCheck(int position) {
        return (position + 1) % 2 == 0;
    }

    public static void checkEmpty(String[] splitFormula) {
        if (isEmpty(splitFormula)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEmpty(String[] list) {
        return list != null && list.length == 0;
    }

}
