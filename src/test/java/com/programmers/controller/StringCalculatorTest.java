package com.programmers.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @MethodSource("testInputString")
    void calculateAllTest(String inputString, int result) {
        Assertions.assertEquals(stringCalculator.calculateAll(inputString), result);

    }

    static Stream<Arguments> testInputString() {
        return Stream.of(
                arguments("10 - 100 * 2", -190),
                arguments("20 - 10 * 5", -30),
                arguments("100 * 100 / 20", 500),
                arguments("1000 + 2000 + 3000 - 1000 * 3", 3000));
    }

}