package com.programmers.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private final String parameterClass = "com.programmers.parameterized.CalculatorParams";
    private final Calculator cal = new Calculator();

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateOnlyPlus")
    void calculateOnlyPlus(List<String> postfixExpression, int result) {
        //when
        int calculated = cal.calculatePostfixExpression(postfixExpression);

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateOnlyMinus")
    void calculateOnlyMinus(List<String> postfixExpression, int result) {
        //when
        int calculated = cal.calculatePostfixExpression(postfixExpression);

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateMixedWithPlusAndMinus")
    void calculateMixedWithPlusAndMinus(List<String> postfixExpression, int result) {
        //when
        int calculated = cal.calculatePostfixExpression(postfixExpression);

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateOnlyMultiply")
    void calculateOnlyMultiply(List<String> postfixExpression, int result) {
        //when
        int calculated = cal.calculatePostfixExpression(postfixExpression);

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateMultiplyMixedWithPlusAndMinus")
    void calculateMultiplyMixedWithPlusAndMinus(List<String> postfixExpression, int result) {
        //when
        int calculated = cal.calculatePostfixExpression(postfixExpression);

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateOnlyDivide")
    void calculateOnlyDivide(List<String> postfixExpression, int result) {
        //when
        int calculated = cal.calculatePostfixExpression(postfixExpression);

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateMixedAllOperation")
    void calculateMixedAllOperation(List<String> postfixExpression, int result) {
        //when
        int calculated = cal.calculatePostfixExpression(postfixExpression);

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @Test
    void calculateDivideByZero_Then_Exception() {
        //given
        List<String> inputsA = List.of("123", "0", "/");

        //when

        //then
        assertThatThrownBy(() -> cal.calculatePostfixExpression(inputsA))
                .isInstanceOf(ArithmeticException.class);
    }
}
