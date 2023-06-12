package com.programmers.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private final Calculator cal = new Calculator();

    @Test
    void calculateOnlyPlus() {
        //given
        List<String> inputsA = List.of("1", "5", "+");
        List<String> inputsB = List.of("123", "234", "2134", "+", "+");
        List<String> inputsC = List.of("1", "2", "+", "3", "+", "4", "+");

        //when
        int resultA = cal.calculatePostfixExpression(inputsA);
        int resultB = cal.calculatePostfixExpression(inputsB);
        int resultC = cal.calculatePostfixExpression(inputsC);

        //then
        assertThat(resultA).isEqualTo(6);
        assertThat(resultB).isEqualTo(123 + 234 + 2134);
        assertThat(resultC).isEqualTo(10);
    }

    @Test
    void calculateOnlyMinus() {
        //given
        List<String> inputsA = List.of("1", "5", "-");
        List<String> inputsB = List.of("123", "23", "-", "523", "-");

        //when
        int resultA = cal.calculatePostfixExpression(inputsA);
        int resultB = cal.calculatePostfixExpression(inputsB);

        //then
        assertThat(resultA).isEqualTo(-4);
        assertThat(resultB).isEqualTo(123 - 23 - 523);
    }

    @Test
    void calculateMixedWithPlusAndMinus() {
        //given
        List<String> inputsA = List.of("1", "5", "+", "123", "-");
        List<String> inputsB = List.of("123", "2345", "-", "2452", "+");

        //when
        int resultA = cal.calculatePostfixExpression(inputsA);
        int resultB = cal.calculatePostfixExpression(inputsB);

        //then
        assertThat(resultA).isEqualTo(1 + 5 - 123);
        assertThat(resultB).isEqualTo(123 - 2345 + 2452);

    }

    @Test
    void calculateOnlyMultiply() {
        //given
        List<String> inputsA = List.of("2", "5", "*");
        List<String> inputsB = List.of("123", "123", "*", "948", "*");

        //when
        int resultA = cal.calculatePostfixExpression(inputsA);
        int resultB = cal.calculatePostfixExpression(inputsB);

        //then
        assertThat(resultA).isEqualTo(2 * 5);
        assertThat(resultB).isEqualTo(123 * 123 * 948);
    }

    @Test
    void calculateMultiplyMixedWithPlusAndMinus() {
        //given
        List<String> inputsA = List.of("123", "324", "3", "*", "+", "2332", "-");
        List<String> inputsB = List.of("123", "324", "*", "32", "42", "*", "-");

        //when
        int resultA = cal.calculatePostfixExpression(inputsA);
        int resultB = cal.calculatePostfixExpression(inputsB);

        //then
        assertThat(resultA).isEqualTo(123 + 324 * 3 - 2332);
        assertThat(resultB).isEqualTo(123 * 324 - 32 * 42);
    }

    @Test
    void calculateOnlyDivide() {
        //given
        List<String> inputsA = List.of("123", "23", "/");
        List<String> inputsB = List.of("34", "42", "/", "35", "/");

        //when
        int resultA = cal.calculatePostfixExpression(inputsA);
        int resultB = cal.calculatePostfixExpression(inputsB);

        //then
        assertThat(resultA).isEqualTo(123 / 23);
        assertThat(resultB).isEqualTo(34 / 42 / 35);
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

    @Test
    void calculateMixedAllOperation() {
        //given
        List<String> inputsA = List.of("23", "7", "*", "32", "8", "/", "+");
        List<String> inputsB = List.of("23", "3", "23", "*", "2", "/", "12", "17", "*", "-", "+");

        //when
        int resultA = cal.calculatePostfixExpression(inputsA);
        int resultB = cal.calculatePostfixExpression(inputsB);

        //then
        assertThat(resultA).isEqualTo(23 * 7 + 32 / 8);
        assertThat(resultB).isEqualTo(23 + 3 * 23 / 2 - 12 * 17);
    }

}
