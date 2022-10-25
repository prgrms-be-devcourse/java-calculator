package org.programmers.java.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.model.Menu;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;

@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorServiceImpl calculatorServiceImpl;

    public String record() {
        return calculatorServiceImpl.record();
    }
}
