package com.programmers.java;

import com.programmers.java.calculator.calculate.Calculator;
import com.programmers.java.repository.ResultRepository;
import com.programmers.java.util.ExpressionTokenizer;
import com.programmers.java.view.Button;
import com.programmers.java.view.Input;
import com.programmers.java.view.Output;

import java.io.IOException;

public class Main {
    static Output output = new Output();
    static Input input = new Input();
    static Calculator calculator = new Calculator();
    static ResultRepository resultRepository = new ResultRepository();
    static ExpressionTokenizer expressionTokenizer = new ExpressionTokenizer();

    public static void main(String[] args) throws IOException {
        while (true) {
            output.viewStartConsole();

            Button button = input.enterMenu();

            if (button == null) {
                output.viewEndConsole();
                System.exit(0);
            }
            String menu = button.name();
            runCalculator(menu);
        }
    }

    public static void runCalculator(String menu) throws IOException {
        switch (menu) {
            case "CALCULATE":
                String expression = input.enterExpression();
                Double result = calculator.calculate(expressionTokenizer.expressionSplit(expression));
                output.viewCalculateResult(result);
                resultRepository.save(expression, Double.toString(result));
                break;
            case "SEARCH":
                output.viewSearchResult(resultRepository.getCalculationResults());
                break;
        }
    }
}