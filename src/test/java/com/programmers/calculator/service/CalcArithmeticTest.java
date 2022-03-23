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
        int a = 1;
        int b = 1;

        // when
        Double result = ex.calcPlus(a, b);

        // then
        assertEquals(a + b, result);
    }

    @Test
    @DisplayName("곱셈 연산의 경우")
    void calcMultiTest() {
        // given
        int a = 2;
        int b = 3;

        // when
        Double result = ex.calcMulti(a, b);

        // then
        assertEquals(a * b, result);
    }

    @Test
    @DisplayName("나눗셈 연산의 경우")
    void calcDiviTest() {
        // given
        int a = 2;
        int b = 3;

        // when
        Double result = ex.calcDivi(a, b);

        // then
        assertEquals((double) a / b, result);
    }

    @Test
    @DisplayName("뺄셈 연산의 경우")
    void calcMinusTest() {
        // given
        int a = 2;
        int b = 3;

        // when
        Double result = ex.calcMinus(a, b);

        // then
        assertEquals(a - b, result);
    }

    @Test
    @DisplayName("0으로 나눌 경우")
    void calcDiviByZeroTest() {
        // given
        int a = 2;
        int b = 0;

        // when
        Double result = ex.calcDivi(a, b);

        // then
        assertEquals(0, result);
    }
}
