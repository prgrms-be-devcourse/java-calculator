package com.programmers.domain;

import com.programmers.io.Console;
import com.programmers.service.CalculatorService;
import com.programmers.util.ExpressionProcessor;

import java.util.List;

public class Calculator {

    private static int CALCULATE = 2;

    private final Console console = new Console();
    private final CalculatorService calculatorService = new CalculatorService(console);
    private final ExpressionProcessor expressionProcessor = new ExpressionProcessor();

    public void run() {
        int menuSelection = calculatorService.getValidatedMenuSelection();

        if (menuSelection == CALCULATE) {
            String validatedExpression = calculatorService.getValidatedExpression();
            List<String> tokens = expressionProcessor.parse(validatedExpression);

            tokens.forEach(System.out::println);
        }
    }
}
