package com.programmers.kwonjoosung.java.calculator.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    static ArithmeticCalculator calculator;

    @BeforeAll
    @DisplayName("계산기 생성")
    static void start() {
        calculator = new ArithmeticCalculator();
    }

    @Test
    @DisplayName("기본 사칙연산")
    void cal() {
        assertAll(
                () -> assertEquals("10", calculator.calculate("5 + 5")),
                () -> assertEquals("0", calculator.calculate("5 - 5")),
                () -> assertEquals("25", calculator.calculate("5 * 5")),
                () -> assertEquals("1", calculator.calculate("5 / 5")),
                () -> assertEquals("23", calculator.calculate("11 + 12")),
                () -> assertEquals("-10", calculator.calculate("10 - 20")),
                () -> assertEquals("-55", calculator.calculate("11 * -5")),
                () -> assertEquals("0.67", calculator.calculate("2 / 3"))
        );
    }

    @Test
    @DisplayName("연산자 우선순위")
    void order() {
        assertAll(
                () -> assertEquals("35", calculator.calculate("5 + 5 * 6")),
                () -> assertEquals("4", calculator.calculate("5 - 5 / 5")),
                () -> assertEquals("31", calculator.calculate("5 * 5 + 6")),
                () -> assertEquals("-4", calculator.calculate("5 / 5 - 5")),
                () -> assertEquals("49", calculator.calculate("11 + 12 * 3 / 2 - 10 * -2"))
        );
    }

    @Test
    @DisplayName("0으로 나누기")
    void divZero() {
        // given
        String expression = "1 / 0";
        //when & then
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(expression));
    }

}
