package com.programmers.devcourse.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerCalculatorTest {

    static IntegerCalculator integerCalculator;

    @BeforeAll
    static void setUp() {
        integerCalculator = new IntegerCalculator();
    }

    @Test
    @DisplayName("더하기 테스트")
    void additionTest() {
        List<String> input = Arrays.asList("1", "2", "+");
        assertEquals(3, integerCalculator.calculate(input));
    }

    @Test
    @DisplayName("빼기 테스트")
    void subtractionTest() {
        List<String> input = Arrays.asList("1", "2", "-");
        assertEquals(-1, integerCalculator.calculate(input));
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiTest() {
        List<String> input = Arrays.asList("1", "2", "*");
        assertEquals(2, integerCalculator.calculate(input));
    }

    @Test
    @DisplayName("나누기 테스트")
    void divTest() {
        List<String> input = Arrays.asList("4", "2", "/");
        assertEquals(2, integerCalculator.calculate(input));
    }

    @Test
    @DisplayName("상수항 테스트")
    void constantTest() {
        List<String> input = Arrays.asList("143");
        assertEquals(143, integerCalculator.calculate(input));
    }

    @Test
    @DisplayName("다항식 테스트")
    void expressionTest() {
        List<String> input = Arrays.asList("4", "2", "/", "2", "-", "143234", "+");
        assertEquals(143234, integerCalculator.calculate(input));
    }

    @Test()
    @DisplayName("0으로 나누기 테스트")
    void divByZeroTest() {
        List<String> input = Arrays.asList("4", "0", "/");
        assertThrows(java.lang.ArithmeticException.class, ()-> integerCalculator.calculate(input));
    }
}