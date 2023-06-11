package com.programmers.java;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCalculate1() {
        String expression1 = "2+3*4";
        BigDecimal expected1 = new BigDecimal("14");
        try {
            BigDecimal result1 = Calculator.calculate(expression1);
            assertEquals(expected1, result1);
        } catch (Exception e) {
            fail("Exception thrown for valid input: " + expression1);
        }
    }

    @Test
    void testCalculate2() {
        String expression2 = "7-(5/2.5)+3";
        BigDecimal expected2 = new BigDecimal("8");
        try {
            BigDecimal result2 = Calculator.calculate(expression2);
            assertEquals(expected2, result2);
        } catch (Exception e) {
            fail("Exception thrown for valid input: " + expression2);
        }
    }

    @Test
    void testCalculate3() {
        String expression2 = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111.1+111111111111111111111111111111111111111111111111111111111111111111111111111111111111.2";
        BigDecimal expected2 = new BigDecimal("222222222222222222222222222222222222222222222222222222222222222222222222222222222222.3");
        try {
            BigDecimal result2 = Calculator.calculate(expression2);
            assertEquals(expected2, result2);
        } catch (Exception e) {
            fail("Exception thrown for valid input: " + expression2);
        }
    }
}