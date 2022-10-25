package com.programmers.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTypeTest {

    @ParameterizedTest
    @MethodSource
    void calculate(char sign, int numOne, int numTwo, int result) {
        assertEquals(CalculatorType.selectType(sign).calculate(numOne, numTwo), result);
    }

    static Stream<Arguments> calculate() {
        return Stream.of(
                arguments('+', 10, 10, 20),
                arguments('-', 10, 100, -90),
                arguments('*', 10, 10, 100),
                arguments('/', 1000, 10, 100));
    }

    @Test
    void divideZero() {
        assertThrows(ArithmeticException.class, () -> {
            CalculatorType.DIVIDE.calculate(100, 0);
        });
    }
}