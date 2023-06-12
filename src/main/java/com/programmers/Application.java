package com.programmers;

import com.programmers.controller.CalculatorController;
import com.programmers.engine.PostfixCalculator;
import com.programmers.io.Console;
import com.programmers.repository.CalculatorHistory;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
                new Console(),
                new PostfixCalculator(),
                new CalculatorHistory()
        );
        calculatorController.run();

    }

}
