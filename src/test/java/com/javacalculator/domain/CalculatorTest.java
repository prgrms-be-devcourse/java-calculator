package com.javacalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void 수식을_계산한다() {
        // given
        List<Integer> operands = new LinkedList<>(List.of(6, 2, 1));
        List<String> operators = new LinkedList<>(List.of("-", "/"));
        Calculator calculator = new Calculator();

        // when
        int result = calculator.calculate(operands, operators);

        // then
        assertThat(result).isEqualTo(4);
    }
}
