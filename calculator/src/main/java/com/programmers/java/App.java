package com.programmers.java;

import com.programmers.java.application.Console;
import com.programmers.java.application.Operator;
import com.programmers.java.engine.CalculatorImpl;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Operator operator = new Operator();

        new CalculatorImpl(operator, console).run();
    }
}
