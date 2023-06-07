package com.programmers;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        CalculateResult calculateResult = new CalculateResult();
        new JavaCalculator(console, console, calculateResult).run();
    }
}
