package com.programmers.calculator;

import com.programmers.calculator.domain.CalculationResult;
import com.programmers.calculator.domain.Expression;
import com.programmers.calculator.domain.Menu;
import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;

import java.util.concurrent.atomic.AtomicBoolean;

public class CalculatorController implements Runnable {
    private final Input input;
    private final Output output;
    private final Calculator calculator;

    public CalculatorController(Input input, Output output, Calculator calculator) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
    }

    @Override
    public void run() {
        AtomicBoolean running = new AtomicBoolean(true);

        while (running.get()) {
            output.displayMenu();
            Menu menu = input.selectMenu();

            switch (menu) {
                case HISTORY -> getHistory();
                case CALCULATE -> calculate();
                case EXIT -> running.set(false);
            }
        }
    }

    private void getHistory() {
        calculator.findCalculationHistory()
                .forEach(output::displayResult);
    }

    private void calculate() {
        Expression expression = input.readExpression();
        double result = calculator.calculate(expression.toPostfix());

        CalculationResult calculationResult = new CalculationResult(expression.getValue(), result);
        calculator.saveCalculationResult(calculationResult);

        output.displayResult(result);
    }
}
