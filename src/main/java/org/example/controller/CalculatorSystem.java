package org.example.controller;

import org.example.domain.Calculator;
import org.example.util.Command;
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

            Command command = Command.getCommand(calculatorView.readCommand());

            if (command == Command.HISTORY) {
                calculatorView.printHistory(calculator);
            }
            if (command == Command.CALCULATE) {
                String expression = calculatorView.readExpression();
                calculatorView.printCalcResult(calculator.execute(expression));
            }
            if (command == Command.END) {
                break;
            }
        }
    }
}
