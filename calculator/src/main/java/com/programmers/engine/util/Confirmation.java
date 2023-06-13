package com.programmers.engine.util;

public class Confirmation {

    public static boolean isOperand(String element) {
        return element.matches("[0-9]+");
    }

    public static boolean isOperator(String element) {
        return element.matches("[+\\-*/]");
    }
}
