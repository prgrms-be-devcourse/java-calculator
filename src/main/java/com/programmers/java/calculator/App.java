package com.programmers.java.calculator;

import com.programmers.java.calculator.io.ConsoleInput;
import com.programmers.java.calculator.io.ConsoleOutput;
import com.programmers.java.calculator.model.MemoryExpressionRepository;

public class App {
    public static void main(String[] args) {
        Console console = new Console(
                new ConsoleInput(),
                new ConsoleOutput(),
                new MemoryExpressionRepository(),
                new ArithmeticModule());

        new Calculator(console).run();
    }
}
