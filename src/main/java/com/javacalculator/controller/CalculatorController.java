package com.javacalculator.controller;

import com.javacalculator.domain.Calculator;
import com.javacalculator.domain.Menu;
import com.javacalculator.dto.CalculatorRequest;
import com.javacalculator.view.InputView;
import com.javacalculator.view.OutputView;

public class CalculatorController {

    public static void main(String[] args) {
        while (true) {
            OutputView.outputMenu();
            Menu menu = Menu.from(InputView.inputMenuNumber());
            Calculator calculator = new Calculator();

            if (menu == Menu.SECOND) {
                CalculatorRequest request = InputView.inputExpression();
                int result = calculator.calculate(request);
                OutputView.outputCalculatedResult(result);
            }
        }
    }
}
