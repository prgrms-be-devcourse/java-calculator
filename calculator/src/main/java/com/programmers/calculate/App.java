package com.programmers.calculate;

import com.programmers.calculate.engine.Calculator;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        CalculatorHistory history = new CalculatorHistory();

        new Calculator(console, console, history).run();

    }
}
