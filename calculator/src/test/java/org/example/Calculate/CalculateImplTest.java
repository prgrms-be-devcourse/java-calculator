package org.example.Calculate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class CalculateImplTest {

    PreProcess preProcess = new PreProcessImpl();
    Calculate calculator = new Calculator(new CalOrderImpl());

    @Test
    void calculateTest() {
        String expression = "2 * 3 - 6 / 3";
        Stack<String> expressionStack = preProcess.expressionToStack(expression);
        int result = calculator.calculate(expressionStack);
        Assertions.assertEquals(result, 4);
    }

    @Test
    void calculateTest2() {
        String expression = "3 * 6 * 2 / 2";
        Stack<String> expressionStack = preProcess.expressionToStack(expression);
        int result = calculator.calculate(expressionStack);
        Assertions.assertEquals(result, 18);
    }

    @Test
    void calculateTest3() {
        String expression = "3 + 6 + 2 + 2";
        Stack<String> expressionStack = preProcess.expressionToStack(expression);
        int result = calculator.calculate(expressionStack);
        Assertions.assertEquals(result, 13);
    }
}