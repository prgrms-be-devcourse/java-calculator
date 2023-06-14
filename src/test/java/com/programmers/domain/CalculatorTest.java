package com.programmers.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private final String parameterClass = "com.programmers.parameterized.CalculatorParams";

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
    @MethodSource(parameterClass + "#validateInvalidOrder_Then_Exception")
    void validateInvalidOrder_Then_Exception(List<String> infixExpression) {
        //then
        assertThatThrownBy(() -> new Calculator(infixExpression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#validateExpressionEndWithOperator_Then_Exception")
    void validateExpressionEndWithOperator_Then_Exception(List<String> infixExpression) {
        //then
        assertThatThrownBy(() -> new Calculator(infixExpression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#validateValidExpression")
    void validateValidExpression(List<String> expression) {
        //when
        new Calculator(expression);

        //then
    }

    //calculate()
    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateOnlyPlus")
    void calculateOnlyPlus(List<String> infixExpression, int result) {
        //given
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateOnlyMinus")
    void calculateOnlyMinus(List<String> infixExpression, int result) {
        //given
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateMixedWithPlusAndMinus")
    void calculateMixedWithPlusAndMinus(List<String> infixExpression, int result) {
        //given
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateOnlyMultiply")
    void calculateOnlyMultiply(List<String> infixExpression, int result) {
        //given
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateMultiplyMixedWithPlusAndMinus")
    void calculateMultiplyMixedWithPlusAndMinus(List<String> infixExpression, int result) {
        //given
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateOnlyDivide")
    void calculateOnlyDivide(List<String> infixExpression, int result) {
        //given
        Calculator cal = new Calculator(infixExpression);

        //when
        int calculated = cal.calculate();

        //then
        assertThat(calculated).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#calculateMixedAllOperation")
    void calculateMixedAllOperation(List<String> infixExpression, int result) {
        //given
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
