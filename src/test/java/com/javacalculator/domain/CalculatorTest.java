package com.javacalculator.domain;

import com.javacalculator.dto.CalculatorRequest;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void 수식을_계산한다() {
        // given
        Calculator calculator = new Calculator();
        CalculatorRequest request = new CalculatorRequest("6 - 2 / 1",
                new LinkedList<>(List.of(6, 2, 1)), new LinkedList<>(List.of("-", "/")));

        // when
        int result = calculator.calculate(request);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 계산이력을_조회한다() {
        // given
        Calculator calculator = new Calculator();
        calculator.calculate(new CalculatorRequest("6 - 2 / 1",
                new LinkedList<>(List.of(6, 2, 1)), new LinkedList<>(List.of("-", "/"))));

        // when
        Map<String, Integer> result = calculator.getHistories();

        // then
        assertThat(result).containsKeys("6 - 2 / 1").containsValues(4);
    }
}
