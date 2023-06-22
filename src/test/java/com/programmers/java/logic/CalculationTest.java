package com.programmers.java.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CalculationTest {

    private Calculator calculator = new Calculator();


    @ParameterizedTest
    @CsvSource({
            "'2+3*4', 14",
            "'7-(5/2.5)+3', 8",
            "'7-1.1*1.0*7', -0.70",
            "'1111111111.1111111111+6666666666.6666666666', 7777777777.7777777777",
    })
    void testCalculations(String expression, BigDecimal expected) {
        try {
            BigDecimal result = calculator.calculate(expression);
            assertEquals(expected, result);
        } catch (Exception e) {
            fail("Calculator의 인스턴스 내 에러 발생: " + expression);
        }
    }
}