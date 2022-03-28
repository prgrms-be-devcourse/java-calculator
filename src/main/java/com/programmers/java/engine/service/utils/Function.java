package com.programmers.java.engine.service.utils;

public class Function {
    public static boolean isStrDigit(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '-') {
                if (str.length() == 1)
                    return false;
            } else if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean isOperator(String str) {
        if (str.length() > 1)
            return false;
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
