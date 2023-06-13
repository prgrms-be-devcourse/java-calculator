package org.calculator;

import org.calculator.engine.CalculateEngine;
import org.calculator.engine.io.Console;
import org.calculator.engine.io.ConsoleImpl;
import org.calculator.repository.CalculateRepository;
import org.calculator.repository.CalculateRepositoryImpl;

public class App {
    public static void main(String[] args) {
        CalculateEngine calculateEngine = new CalculateEngine();
        CalculateRepository calculateRepository = new CalculateRepositoryImpl();
        Console console = new ConsoleImpl(calculateRepository);
        new Calculator(calculateEngine, console).run();
    }
}
