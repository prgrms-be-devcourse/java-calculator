package com.programmers.java.calculator.parser;

public interface Parser {
    String parse(String exp);

    default boolean isNum(String s) {
        return s.matches("^?\\d*(\\.?\\d*)$");
    }
}
