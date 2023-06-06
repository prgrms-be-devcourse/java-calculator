package com.javacalculator.domain;

import com.javacalculator.dto.CalculatorRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.*;

class CalculatorTest {

    @Test
    void 우선순위를_고려하여_수식을_계산한다() {
        // given
        Calculator calculator = new Calculator();
        CalculatorRequest request = new CalculatorRequest("6 - 2 / 1",
                new LinkedList<>(List.of(6, 2, 1)), new LinkedList<>(List.of("-", "/")));

        // when
        int result = calculator.calculate(request);

        // then
        assertThat(result).isEqualTo(4);
    }

    @ParameterizedTest(name = "[{index}] 6과2를 연산 = {1}")
    @MethodSource
    void 사칙연산을_한다(CalculatorRequest request, int expected) {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.calculate(request);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> 사칙연산을_한다() {
        return Stream.of(
                arguments(new CalculatorRequest("6 + 2",
                        new LinkedList<>(List.of(6, 2)), new LinkedList<>(List.of("+"))), 8),
                arguments(new CalculatorRequest("6 - 2",
                        new LinkedList<>(List.of(6, 2)), new LinkedList<>(List.of("-"))), 4),
                arguments(new CalculatorRequest("6 * 2",
                        new LinkedList<>(List.of(6, 2)), new LinkedList<>(List.of("*"))), 12),
                arguments(new CalculatorRequest("6 / 2",
                        new LinkedList<>(List.of(6, 2)), new LinkedList<>(List.of("/"))), 3)
        );
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
