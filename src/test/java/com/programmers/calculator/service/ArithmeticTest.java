package com.programmers.calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticTest {
    ArithmeticService ex = new ArithmeticService();

    @Test
    @DisplayName("더하기 연산, 1+1 연산 후 결과로 2가 나와야함")
    void plusTest() {
        // given
        double a = 1;
        double b = 1;

        // when
        Double result = ex.calcPlus(a, b);

        // then
        assertEquals(2.0, result);
    }

    @Test
    @DisplayName("곱셈 연산, 2*3 연산 후 결과로 6이 나와야함")
    void multiTest() {
        // given
        double a = 2;
        double b = 3;

        // when
        Double result = ex.calcMulti(a, b);

        // then
        assertEquals(6.0, result);
    }

    @Test
    @DisplayName("나눗셈 연산, 2/3 연산 후 결과로 0.6666666666666666이 나와야함")
    void diviTest() {
        // given
        double a = 2;
        double b = 3;

        // when
        Double result = ex.calcDivi(a, b);

        // then
        assertEquals(0.6666666666666666, result);
    }

    @Test
    @DisplayName("뺄셈 연산, 2-3 연산 후 결과로 -1.0이 나와야함")
    void minusTest() {
        // given
        double a = 2;
        double b = 3;

        // when
        Double result = ex.calcMinus(a, b);

        // then
        assertEquals(-1.0, result);
    }

    @Test
    @DisplayName("0으로 나눌 경우, '0으로 나눌 수 없습니다.'란 에러 메시지를 출력해야함")
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
