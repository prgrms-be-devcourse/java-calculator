package com.programmers.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionValidatorTest {
    ExpressionValidator validator = new ExpressionValidator();

    @Test
    void validateInvalidOrder_Then_Exception() {
        //given
        List<String> inputA = List.of("1", "1", "1");
        List<String> inputB = List.of("+", "1", "/");
        List<String> inputC = List.of("1", "+");

        //when


        //then
        assertThatThrownBy(() -> validator.validate(inputA))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> validator.validate(inputB))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> validator.validate(inputC))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validateInvalidOperator_Then_Exception() {
        //given
        List<String> inputA = List.of("1", "++", "1");
        List<String> inputB = List.of("1", " ", "2");
        List<String> inputC = List.of("1", "", "2");

        //when

        //then
        assertThatThrownBy(() -> validator.validate(inputA))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> validator.validate(inputB))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> validator.validate(inputC))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validateValidExpression() {
        //given
        List<String> inputA = List.of("1", "+", "1");
        List<String> inputB = List.of("1", "/", "1", "*", "1");

        //when
        validator.validate(inputA);
        validator.validate(inputB);

        //then

    }
}