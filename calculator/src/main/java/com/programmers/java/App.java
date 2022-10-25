package com.programmers.java;

import com.programmers.java.application.Console;
import com.programmers.java.application.Operator;
import com.programmers.java.engine.*;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Operator operator = new Operator();
        HistoryRepository historyRepository = new HistoryInMemoryInterface();
        Calculator calculator = new CalculatorImpl(operator);

        new Menu(console, calculator, historyRepository).run();
    }
}
