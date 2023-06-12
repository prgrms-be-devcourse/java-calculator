package com.programmers;

import com.programmers.engine.Calculator;
import com.programmers.engine.PostfixCalculator;
import com.programmers.io.Console;
import com.programmers.repository.CalculatorHistory;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(
                new Console(),
                new PostfixCalculator(),
                new CalculatorHistory()
        );
        calculator.run();

    }

}
