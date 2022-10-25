package org.programmers.java;

import org.programmers.java.calculator.Calculator;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;

public class App {
    public static void main(String[] args) {

        CalculatorRepositoryImpl calculatorRepository = new CalculatorRepositoryImpl();
        CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl(calculatorRepository);
        CalculatorController calculatorController = new CalculatorController(calculatorServiceImpl);
        Console console = new Console();

        Calculator calculator = new Calculator(calculatorController, console);
        calculator.run();
    }
}