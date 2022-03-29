package main.calculator;

import main.calculator.engine.Console;

public class Main {
    public static void main(String[] args) {

        Console console = new Console();
        new Calculator(console,console).run();
    }
}
