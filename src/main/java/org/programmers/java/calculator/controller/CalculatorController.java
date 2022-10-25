package org.programmers.java.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;

@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorServiceImpl calculatorServiceImpl;

}
