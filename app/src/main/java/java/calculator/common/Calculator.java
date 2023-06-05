package java.calculator.common;

import java.calculator.common.engine.CalculatorEngine;

public class Calculator {

    public int calculate(String rawExpression) {
        return new CalculatorEngine(rawExpression).evaluate();
    }
}
