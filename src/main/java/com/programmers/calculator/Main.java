package com.programmers.calculator;

import com.programmers.calculator.engine.Calculator;
import com.programmers.calculator.engine.io.Console;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();

        new Calculator(console, console).run();
    }
}