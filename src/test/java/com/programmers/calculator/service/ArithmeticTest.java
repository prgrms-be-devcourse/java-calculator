package com.programmers.calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticTest {
    ArithmeticService ex = new ArithmeticService();

    @Test
    @DisplayName("더하기 연산의 경우")
    void plusTest() {
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
    void multiTest() {
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
    void diviTest() {
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
    void minusTest() {
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
    void diviByZeroTest() {
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
