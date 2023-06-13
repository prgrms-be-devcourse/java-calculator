package com.programmers.java;

import com.programmers.java.calculator.calculate.Calculator;
import com.programmers.java.repository.ResultRepository;
import com.programmers.java.util.ExpressionTokenizer;
import com.programmers.java.view.Menu;
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

            input.enterMenu().ifPresentOrElse(
                    Main::runCalculator,
                    () -> System.exit(0));
        }
    }

    public static void runCalculator(Menu menu) {
        switch (menu) {
            case CALCULATE:
                calculator();
                break;
            case SEARCH:
                output.viewSearchResult(resultRepository.getCalculationResults());
                break;
        }
    }

    private static void calculator() {
        String expression = null;
        try {
            expression = input.enterExpression();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Double result = calculator.calculate(expressionTokenizer.expressionSplit(expression));
        output.viewCalculateResult(result);
        resultRepository.save(expression, Double.toString(result));
    }
}