package com.programmers.calculate;

import com.programmers.calculate.engine.Calculator;

public class App {
    public static void main(String[] args) {
        Console console = new Console();

        new Calculator(console, console).run();

    }
}
