package com.programmers.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionValidatorTest {
    private final String parameterClass = "com.programmers.parameterized.ExpressionValidatorParams";
    ExpressionValidator validator = new ExpressionValidator();

    @Test
    void validateInvalidOperator_Then_Exception() {
        //given
        List<String> expression = List.of("1", "++", "1");

        //when

        //then
        assertThatThrownBy(() -> validator.validate(expression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validateOperatorButBlank_Then_Exception() {
        //given
        List<String> expression = List.of("1", " ", "2");

        //when

        //then
        assertThatThrownBy(() -> validator.validate(expression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validateOperatorButEmpty_Then_Exception() {
        //given
        List<String> expression = List.of("1", "", "2");

        //when

        //then
        assertThatThrownBy(() -> validator.validate(expression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#validateInvalidOrder_Then_Exception")
    void validateInvalidOrder_Then_Exception(List<String> infixExpression) {
        //then
        assertThatThrownBy(() -> validator.validate(infixExpression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#validateExpressionEndWithOperator_Then_Exception")
    void validateExpressionEndWithOperator_Then_Exception(List<String> expression) {
        //then
        assertThatThrownBy(() -> validator.validate(expression))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#validateValidExpression")
    void validateValidExpression(List<String> expression) {
        //when
        validator.validate(expression);

        //then
    }
}