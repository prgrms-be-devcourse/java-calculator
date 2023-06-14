package com.programmers.util;

import com.programmers.domain.Calculator;

import java.util.Arrays;
import java.util.List;

public class CalculatorTestUtil {
    public static Calculator createCalculation(String expression) {
        List<String> expressionList = Arrays.stream(expression.split(" ")).toList();

        Calculator calculator = new Calculator(expressionList);
        calculator.calculate();

        return calculator;
    }
}
