package com.javacalculator.controller;

import com.javacalculator.domain.Calculator;
import com.javacalculator.domain.Menu;
import com.javacalculator.dto.CalculatorRequest;
import com.javacalculator.view.InputView;
import com.javacalculator.view.OutputView;

import java.util.Map;

public class CalculatorController {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        while (true) {
            OutputView.outputMenu();
            Menu menu = Menu.from(InputView.inputMenuNumber());

            if (menu == Menu.FIRST) {
                Map<String, Integer> histories = calculator.getHistories();
                OutputView.outputHistories(histories);
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
