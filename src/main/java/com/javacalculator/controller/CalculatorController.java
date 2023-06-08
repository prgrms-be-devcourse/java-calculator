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
        Menu menu;
        do {
            OutputView.outputMenu();
            int inputMenuNumber = InputView.inputMenuNumber();
            menu = Menu.from(inputMenuNumber);

            if (menu.isHistory()) {
                OutputView.outputHistories(calculator.getHistories());
                continue;
            }

            if (menu.isCalculation()) {
                CalculatorRequest request = InputView.inputExpression();
                int result = calculator.calculate(request);
                OutputView.outputCalculatedResult(result);
            }
        } while (!menu.isEnd());
    }
}
