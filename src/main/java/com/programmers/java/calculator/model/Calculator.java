package com.programmers.java.calculator.model;

import com.programmers.java.calculator.MenuType;
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
                MenuType selecedtmenuType = MenuType.of(inputMenuType);

                switch (selecedtmenuType) {
                    case HISTORY -> System.out.println("조회 중");
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
                output.inputError(e.getMessage());
            }
        }
    }
}
