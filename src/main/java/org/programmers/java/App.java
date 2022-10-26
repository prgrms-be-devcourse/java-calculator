package org.programmers.java;

import org.programmers.java.calculator.Calculator;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.repository.CalculatorRepository;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;
import org.programmers.java.calculator.service.CalculatorService;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;

public class App {
    public static void main(String[] args) {

        CalculatorRepository<String> calculatorRepository = new CalculatorRepositoryImpl();
        CalculatorService calculatorService = new CalculatorServiceImpl(calculatorRepository);
        CalculatorController calculatorController = new CalculatorController(calculatorService);
        Console console = new Console();

        Calculator calculator = new Calculator(calculatorController, console);
        calculator.run();
    }
}