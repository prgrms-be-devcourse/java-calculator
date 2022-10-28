package com.programmers.calculator.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("올바른 수식이 넣으면 연산결과를 반환한다.")
    void calculateRightFormula() {
        // given
        String[] inputFormula = new String[] {
                "1 + 1",
                "1 * 3 + 1",
                "1 + 3 * 4",
                "1 / 3 * 4",
                "3.1 + 4.2 + 5.3"
        };

        String[][] parsedInputFormula = new String[inputFormula.length][];
        for (int i = 0; i < 5; i++) {
            parsedInputFormula[i] = calculator.parseFolmula(inputFormula[i]);
        }

        // when
        var operation0 = calculator.calculate(inputFormula[0], parsedInputFormula[0]);
        var operation1 = calculator.calculate(inputFormula[1], parsedInputFormula[1]);
        var operation2 = calculator.calculate(inputFormula[2], parsedInputFormula[2]);
        var operation3 = calculator.calculate(inputFormula[3], parsedInputFormula[3]);
        var operation4 = calculator.calculate(inputFormula[4], parsedInputFormula[4]);

        // then
        assertEquals("2", operation0.getResult());
        assertEquals("4", operation1.getResult());
        assertEquals("13", operation2.getResult());
        assertEquals("1.33", operation3.getResult());
        assertEquals("12.6", operation4.getResult());
    }

    @Test
    @DisplayName("0으로 나누면 Optional.empty() 반환한다.")
    void calculateWrongFormula() {
        // given
        String inputFormula = "10 * 10 / 0";
        String[] parsedInputFormula = new String[]{"10", "*","10", "/", "0"};

        // when, then
        //assertEquals(Optional.empty(), calculator.calculate(inputFormula, parsedInputFormula));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(inputFormula, parsedInputFormula));
    }
}