package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.Calculation;
import com.programmers.java.calculator.engine.Calculator;
import com.programmers.java.calculator.engine.HistoryStore;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Calculation calculation = new Calculation();
        HistoryStore historyStore = new HistoryStore();

        Calculator calculator = new Calculator(calculation, historyStore, console, console);
        calculator.run();
    }
}
