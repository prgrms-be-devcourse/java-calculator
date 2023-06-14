package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.Calculator;

public class App {
    private static Calculator calculator = new Calculator();
    public static void main(String[] args) {
        calculator.run();
    }
}
