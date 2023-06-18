package com.programmers.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    //validate()
    @Test
    void validateInvalidOperator_Then_Exception() {
        //given
        List<String> expression = List.of("1", "++", "1");

        //when

        //then
        assertThatThrownBy(() -> new Calculator(expression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validateOperatorButBlank_Then_Exception() {
        //given
        List<String> expression = List.of("1", " ", "2");

        //when

        //then
        assertThatThrownBy(() -> new Calculator(expression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validateOperatorButEmpty_Then_Exception() {
        //given
        List<String> expression = List.of("1", "", "2");

        //when

        //then
        assertThatThrownBy(() -> new Calculator(expression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 1 1",
            "+ 1 /",
            "1 + + 1"
    })
    void validateInvalidOrder_Then_Exception(String input) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();

        //then
        assertThatThrownBy(() -> new Calculator(infixExpression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 +",
            "1 * 1 -"
    })
    void validateExpressionEndWithOperator_Then_Exception(String input) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();

        //then
        assertThatThrownBy(() -> new Calculator(infixExpression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 1",
            "1 / 1 * 1"
    })
    void validateValidExpression(String input) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();

        //when
        new Calculator(infixExpression);

        //then
    }

    //calculate()
    @ParameterizedTest
    @CsvSource(value = {
            "1 + 5:6",
            "123 + 234 + 2134:2491",
            "1 + 2 + 3 + 4:10"
    }, delimiter = ':')
    void calculateOnlyPlus(String input, int result) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 - 5:-4",
            "123 - 23 - 523:-423"
    }, delimiter = ':')
    void calculateOnlyMinus(String input, int result) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 5 - 123:-117",
            "123 - 2345 + 2452:230"
    }, delimiter = ':')
    void calculateMixedWithPlusAndMinus(String input, int result) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 * 5:10",
            "20 * 5 * 5:500"
    }, delimiter = ':')
    void calculateOnlyMultiply(String input, int result) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "100 + 30 * 5 - 100:150",
            "120 * 3 - 3 * 100:60"
    }, delimiter = ':')
    void calculateMultiplyMixedWithPlusAndMinus(String input, int result) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "120 / 20:6",
            "80 / 2 / 10:4"
    }, delimiter = ':')
    void calculateOnlyDivide(String input, int result) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "20 * 5 + 18 / 6:103",
            "20 + 5 * 2 / 2 - 12:13"
    }, delimiter = ':')
    void calculateMixedAllOperation(String input, int result) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @Test
    void calculateDivideByZero_Then_Exception() {
        //given
        List<String> infixExpression = List.of("123", "/", "0");
        Calculator cal = new Calculator(infixExpression);

        //when

        //then
        assertThatThrownBy(cal::calculate)
                .isInstanceOf(ArithmeticException.class);
    }

    //toString()
    @Test
    void toString_Then_InfixExpressionAndResult() {
        //given
        List<String> infixExpression = List.of("123", "+", "234");
        Calculator calculator = new Calculator(infixExpression);
        calculator.calculate();

        //when
        String calculation = calculator.toString();

        //then
        assertThat(calculation).isEqualTo("123 + 234 = 357");

    }
}
