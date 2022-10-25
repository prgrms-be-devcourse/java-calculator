package org.programmers.java.calculator;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;

@RequiredArgsConstructor
public class Calculator implements Runnable {

    private final CalculatorController calculatorController;
    private final Console console;
    @Override
    public void run() {

    }
}

