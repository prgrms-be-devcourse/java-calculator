package com.programmers.domain;

import com.programmers.io.Console;
import com.programmers.service.CalculatorService;

public class Calculator {

    private static int CALCULATE = 2;

    private final Console console = new Console();
    private final CalculatorService calculatorService = new CalculatorService(console);

    public void run() {
        int menuSelection = calculatorService.getValidatedMenuSelection();

        if (menuSelection == CALCULATE) {
            String expression = console.getExpressionSpaceRemoved();
            System.out.println(expression);
        }
    }
}
