package com.programmers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("후위 표기식 계산")
    void 후위_표기식_계산() {
        // given
        String postfixExpression = "324*+93/-";
        // when
        double result = calculator.calculate(postfixExpression);
        // then
        assertThat(result).isEqualTo(8);
    }
}
