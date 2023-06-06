package com.javacalculator.controller;

import com.javacalculator.domain.Calculator;
import com.javacalculator.domain.Menu;
import com.javacalculator.dto.CalculatorRequest;
import com.javacalculator.view.InputView;
import com.javacalculator.view.OutputView;

public class CalculatorController {

    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    public void runCalculator() {
        Menu menu = null;
        while (menu != Menu.END) {
            OutputView.outputMenu();
            menu = Menu.from(InputView.inputMenuNumber());

            if (menu == Menu.FIRST) {
                OutputView.outputHistories(calculator.getHistories());
                continue;
            }

            if (menu == Menu.SECOND) {
                CalculatorRequest request = InputView.inputExpression();
                int result = calculator.calculate(request);
                OutputView.outputCalculatedResult(result);
            }
        }
    }
}
