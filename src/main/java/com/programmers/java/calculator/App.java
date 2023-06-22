package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.Calculator;
import com.programmers.java.calculator.engine.io.Console;
import com.programmers.java.calculator.engine.model.MenuNums;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Calculator calculator = new Calculator(console);
        calculator.run();
    }
}
