package com.programmers.calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcArithmeticTest {
    CalcArithmeticService ex = new CalcArithmeticService();

    @Test
    @DisplayName("더하기 연산의 경우")
    void calcPlusTest() {
        // given
        double a = 1;
        double b = 1;

        // when
        Double result = ex.calcPlus(a, b);

        // then
        assertEquals(a + b, result);
    }

    @Test
    @DisplayName("곱셈 연산의 경우")
    void calcMultiTest() {
        // given
        double a = 2;
        double b = 3;

        // when
        Double result = ex.calcMulti(a, b);

        // then
        assertEquals(a * b, result);
    }

    @Test
    @DisplayName("나눗셈 연산의 경우")
    void calcDiviTest() {
        // given
        double a = 2;
        double b = 3;

        // when
        Double result = ex.calcDivi(a, b);

        // then
        assertEquals((double) a / b, result);
    }

    @Test
    @DisplayName("뺄셈 연산의 경우")
    void calcMinusTest() {
        // given
        double a = 2;
        double b = 3;

        // when
        Double result = ex.calcMinus(a, b);

        // then
        assertEquals(a - b, result);
    }

    @Test
    @DisplayName("0으로 나눌 경우")
    void calcDiviByZeroTest() throws Exception {
        // given
        double a = 2;
        double b = 0;

        // when
        Exception exception = assertThrows(ArithmeticException.class,
                () -> ex.calcDivi(a, b));

        // then
        assertTrue(exception.getMessage().contains("0으로 나눌 수 없습니다."));
    }
}
