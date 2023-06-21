package com.programmers.java.calculator.controller;

import com.programmers.java.calculator.domain.CalculationHistory;
import com.programmers.java.calculator.domain.MenuType;
import com.programmers.java.calculator.service.CalculatorService;
import com.programmers.java.calculator.view.Input;
import com.programmers.java.calculator.view.Output;

import java.util.List;

public class CalculatorController {

    private final Input input;
    private final Output output;
    private final CalculatorService calculatorService;

    public CalculatorController(Input input, Output output, CalculatorService calculatorService) {
        this.input = input;
        this.output = output;
        this.calculatorService = calculatorService;
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            try {
                String inputMenuType = input.selectMenu(MenuType.getMenu());
                MenuType selecedtMenuType = MenuType.of(inputMenuType);
                exit = handleMenu(exit, selecedtMenuType);

            } catch (RuntimeException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private boolean handleMenu(boolean exit, MenuType selecedtMenuType) {
        switch (selecedtMenuType) {
            case HISTORY -> displayCalculationHistory();
            case CALCULATE -> performCalculation();
            case END -> exit = true;
        }

        return exit;
    }

    private void displayCalculationHistory() {
        List<CalculationHistory> historyList = calculatorService.getHistoryList();
        output.printHistoryList(historyList);
    }

    private void performCalculation() {
        String expression = input.inputExpression();
        String result = calculatorService.calculate(expression);
        output.printResult(result);
    }
}
