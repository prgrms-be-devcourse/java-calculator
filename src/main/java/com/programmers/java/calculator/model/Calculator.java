package com.programmers.java.calculator.model;

import com.programmers.java.calculator.io.Input;
import com.programmers.java.calculator.io.Output;
import com.programmers.java.calculator.service.CalculatorService;
import com.programmers.java.calculator.validation.Validator;

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
        while (true) {
            try {
                String inputMenuType = input.input(MenuType.getMenu());
                MenuType selecedtMenuType = MenuType.of(inputMenuType);

                switch (selecedtMenuType) {
                    case HISTORY -> output.printHistoryList(calculatorService.getHistoryList());
                    case CALCULATE -> {
                        String expression = input.input();
                        validator.validate(expression);
                        String result = calculatorService.calculate(expression);
                        output.print(result);
                    }
                    case END -> {
                        return;
                    }
                }
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
