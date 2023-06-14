package com.programmers.java.calculator.model;

import com.programmers.java.calculator.entity.CalculationHistory;
import com.programmers.java.calculator.io.Input;
import com.programmers.java.calculator.io.Output;
import com.programmers.java.calculator.service.CalculatorService;
import com.programmers.java.calculator.validation.Validator;

import java.util.List;

public class Calculator {

    private final Input input;
    private final Output output;
    private final CalculatorService calculatorService;
    private final Validator validator;

    public Calculator(Input input, Output output, CalculatorService calculatorService, Validator validator) {
        this.input = input;
        this.output = output;
        this.calculatorService = calculatorService;
        this.validator = validator;
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            try {
                String inputMenuType = input.input(MenuType.getMenu());
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
        String expression = input.input();
        validator.validate(expression);
        String result = calculatorService.calculate(expression);
        output.print(result);
    }
}
