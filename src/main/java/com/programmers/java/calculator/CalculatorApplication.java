package com.programmers.java.calculator;

import com.programmers.java.calculator.controller.CalculatorController;
import com.programmers.java.calculator.domain.calculator.PostfixExpressionCalculator;
import com.programmers.java.calculator.repository.MemoryCalculatorRepository;
import com.programmers.java.calculator.service.CalculatorService;
import com.programmers.java.calculator.util.PostfixExpressionConverter;
import com.programmers.java.calculator.view.Console;

public class CalculatorApplication {

    public static void main(String[] args) {
        Console console = new Console();
        CalculatorService calculatorService = new CalculatorService(
                new PostfixExpressionConverter(),
                new PostfixExpressionCalculator(),
                new MemoryCalculatorRepository());

        new CalculatorController(console, console, calculatorService).run();
    }
}