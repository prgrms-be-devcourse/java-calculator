package com.programmers.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTypeTest {

    @Test
    void plus() {
        assertEquals(CalculatorType.PLUS.calculate(10, 5), 15);
    }

    @Test
    void minus() {
        assertEquals(CalculatorType.MINUS.calculate(10, 100), -90);
    }

    @Test
    void multiply() {
        assertEquals(CalculatorType.MULTIPLY.calculate(10, 10), 100);
    }

    @Test
    void divide() {
        assertEquals(CalculatorType.DIVIDE.calculate(100, 10), 10);
    }

    @Test
    void dividedByZeroException() {
        assertThrows(ArithmeticException.class, () -> {
            CalculatorType.DIVIDE.calculate(100, 0);
        });
    }
}