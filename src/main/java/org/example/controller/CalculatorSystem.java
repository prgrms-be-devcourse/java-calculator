package org.example.controller;

import org.example.domain.Calculator;
import org.example.view.CalculatorView;

public class CalculatorSystem {
    private Calculator calculator;
    private CalculatorView calculatorView;

    public CalculatorSystem() {
        this.calculator = Calculator.getInstance();
        this.calculatorView = new CalculatorView();
    }

    public void run() {
        while (true) {
            calculatorView.printOptionMessage();
            Integer command = calculatorView.readCommand();

            if (command == 1) {
                calculatorView.printMemory(calculator);
            }
            if (command == 2) {
                String expression = calculatorView.readExpression();
                calculatorView.printCalcResult(calculator.execute(expression));
            }
        }
    }
}
