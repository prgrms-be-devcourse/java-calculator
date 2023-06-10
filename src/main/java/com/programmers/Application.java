package com.programmers;

import com.programmers.engine.Calculator;
import com.programmers.engine.PostfixCalculator;
import com.programmers.io.Console;
import com.programmers.repository.CalculatorHistory;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(
                consoleInstance(),
                consoleInstance(),
                postfixCalculatorInstance(),
                calculatorHistoryInstance()
        );
        calculator.run();

    }

    private static Console consoleInstance() {
        return new Console();
    }

    private static PostfixCalculator postfixCalculatorInstance() {
        return new PostfixCalculator();
    }

    private static CalculatorHistory calculatorHistoryInstance() {
        return new CalculatorHistory();
    }

}
