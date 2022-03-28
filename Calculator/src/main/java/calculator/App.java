package calculator;

import calculator.engine.Calculator;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        HashMap<String, Double> map = new HashMap<String, Double>();

        new Calculator(console, console, map).run();
    }
}
