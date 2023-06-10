package org.calculator;

import org.calculator.engine.CalculateEngine;
import org.calculator.engine.io.Console;
import org.calculator.engine.io.Input;
import org.calculator.engine.io.Output;
import org.calculator.repository.CalculateRepository;
import org.calculator.repository.CalculateRepositoryImpl;

public class App {
    public static void main(String[] args) {
        Input input = new Console();
        Output output = new Console();
        CalculateEngine calculateEngine = new CalculateEngine();
        CalculateRepository calculateRepository = new CalculateRepositoryImpl();
        new Calculator(calculateEngine, input, output, calculateRepository).run();
    }
}
