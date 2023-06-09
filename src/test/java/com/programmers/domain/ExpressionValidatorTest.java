package com.programmers.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionValidatorTest {
    ExpressionValidator validator = new ExpressionValidator();

    @Test
    void validateInvalidOrder_Then_Exception() {
        //given
        String[] inputA = {"1", "1", "1"};
        String[] inputB = {"+", "1", "/"};
        String[] inputC = {"1", "+"};

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
        String[] inputA = {"1", "++", "1"};
        String[] inputB = {"1", " ", "2"};
        String[] inputC = {"1", "", "2"};

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
        String[] inputA = {"1", "+", "1"};
        String[] inputB = {"1", "/", "1", "*", "1"};

        //when
        validator.validate(inputA);
        validator.validate(inputB);

        //then

    }
}