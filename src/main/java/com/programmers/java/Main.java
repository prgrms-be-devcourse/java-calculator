package com.programmers.java;

import com.programmers.java.calculator.calculate.Calculator;
import com.programmers.java.calculator.calculate.PostfixConverter;
import com.programmers.java.record.CalculationRecord;
import com.programmers.java.util.ExpressionTokenizer;
import com.programmers.java.view.Menu;
import com.programmers.java.view.Input;
import com.programmers.java.view.Output;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    static Output output = new Output();
    static Input input = new Input();
    static Calculator calculator = new Calculator();
    static CalculationRecord calculationRecord = new CalculationRecord();
    static ExpressionTokenizer expressionTokenizer = new ExpressionTokenizer();
    static PostfixConverter postfixConverter = new PostfixConverter();

    static boolean isRunning = true;

    public static void main(String[] args) throws IOException {
        while (isRunning) {
            output.viewMenu();

            input.enterMenu().ifPresentOrElse(
                    Main::runCalculator,
                    () -> {
                        isRunning = false;
                        output.viewEndMessage();
                    }
            );
        }
    }

    public static void runCalculator(Menu menu) {
        switch (menu) {
            case CALCULATE:
                calculator();
                break;
            case SEARCH:
                output.viewSearchResult(calculationRecord.getCalculationResults());
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

        List<String> tokenList = expressionTokenizer.expressionSplit(expression);

        Double result = calculator.calculate((postfixConverter.postfixConvert(tokenList)));
        output.viewCalculateResult(result);
        calculationRecord.save(expression, Double.toString(result));
    }
}