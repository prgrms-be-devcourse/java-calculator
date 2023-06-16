package com.programmers.java.calculator.calculate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculatePlus() {
        double result = calculator.calculate("3 5 PLUS");
        Assertions.assertEquals(8.0, result);
    }

    @Test
    void calculateMinus() {
        double result = calculator.calculate("3 5 MINUS");
        Assertions.assertEquals(-2.0, result);
    }

    @Test
    void calculateDivide() {
        double result = calculator.calculate("8 4 DIVIDE");
        Assertions.assertEquals(2, result);
    }

    @Test
    void calculateMultiple() {
        double result = calculator.calculate("3 5 MULTIPLE");
        Assertions.assertEquals(15, result);
    }

    @Test
    void calculate() {
        double result = calculator.calculate("3 5 3 MULTIPLE PLUS");
        Assertions.assertEquals(18, result);
    }
}