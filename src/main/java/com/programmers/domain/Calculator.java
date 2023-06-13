package com.programmers.domain;

import com.programmers.io.Console;
import com.programmers.service.CalculatorService;

public class Calculator {

    private static int GET_RESULT = 1;
    private static int TERMINATE = 3;

    private final Console console = new Console();
    private final CalculatorService calculatorService = new CalculatorService(console);

    public void run() {
        int menuSelection = calculatorService.getValidatedMenuSelection();

        while (true) {
            if (menuSelection == TERMINATE) {
                console.printTermination();
                break;
            }

            if (menuSelection == GET_RESULT) {
                calculatorService.getResult();
                menuSelection = calculatorService.getValidatedMenuSelection();
                continue;
            }

            System.out.println();
            calculatorService.calculate();
            menuSelection = calculatorService.getValidatedMenuSelection();
        }
    }
}
