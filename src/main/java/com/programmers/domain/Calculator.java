package com.programmers.domain;

import com.programmers.io.Console;
import com.programmers.service.CalculatorService;

public class Calculator {

    private final Console console = new Console();
    private final CalculatorService calculatorService = new CalculatorService(console);

    public void run() {
        int menuSelection = calculatorService.getValidatedMenuSelection();
        System.out.println(menuSelection);
    }
}
