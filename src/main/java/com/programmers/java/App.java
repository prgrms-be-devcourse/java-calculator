package com.programmers.java;

import com.programmers.java.engine.CalculatorController;
import com.programmers.java.engine.calculator.PostfixCalculator;
import com.programmers.java.engine.io.ConsoleIOController;
import com.programmers.java.engine.repository.MemoryHistoryRepository;
import com.programmers.java.engine.util.translator.InfixToPostfixTranslator;

public class App {
    public static void main(String[] args) {

        new CalculatorController(
                new ConsoleIOController(System.in, System.out),
                new PostfixCalculator(Integer.class),
                new InfixToPostfixTranslator(),
                new MemoryHistoryRepository()
        ).run();
    }
}
