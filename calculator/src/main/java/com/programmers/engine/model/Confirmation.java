package com.programmers.engine.model;

public class Confirmation {

    static boolean isOperand(String element) {
        return element.matches("[0-9]+");
    }

    static boolean isOperator(String element) {
        return element.matches("[+\\-*/]");
    }
}
