package com.programmers.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    Calculator calculator;
    CalculatorRepository calculatorRepository;

    @BeforeEach
    void beforeEach() {
        calculatorRepository = new MemoryCalculatorRepository();
        calculator = new Calculator(calculatorRepository);
    }

    @Test
    @DisplayName("후위 표기식 계산을 성공한다.")
    void 후위_표기식_계산() {
        // given
        String postfixExpression = "30 2 4 * + 9 3 / -";
        // when
        double result = calculator.calculate(postfixExpression);
        // then
        assertThat(result).isEqualTo(35);
    }
}
