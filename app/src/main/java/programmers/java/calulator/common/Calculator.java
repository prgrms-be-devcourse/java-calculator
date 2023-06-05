package programmers.java.calulator.common;

import programmers.java.calulator.common.engine.CalculatorEngine;

public class Calculator {

    public int calculate(String rawExpression) {
        return new CalculatorEngine(rawExpression).evaluate();
    }
}
