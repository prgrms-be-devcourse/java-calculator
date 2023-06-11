package com.programmers.java.calculator;

import com.programmers.java.calculator.io.Console;
import com.programmers.java.calculator.model.Calculator;

public class CalculatorApplication {

    public static void main(String[] args) {
        Console console = new Console();

        new Calculator(console, console).run();
    }
}