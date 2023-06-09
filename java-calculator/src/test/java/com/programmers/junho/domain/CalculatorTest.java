package com.programmers.junho.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("계산 결과 테스트")
    @ParameterizedTest(name = "식: {0}, 결과: {1}")
    @CsvSource(value = {"1 + 2:3", "1 + 2 * 3:7", "3 - 2 * 2:-1", "44 / 2 * 8:176", "22 * 8:176", "12 + 44 / 2 * 8 - 10 + 18 / 2 / 3:181"}, delimiter = ':')
    void name(String expression, int calculatedResult) {
        Calculator calculator = new Calculator(expression);

        int actual = calculator.calculate();

        assertThat(actual).isEqualTo(calculatedResult);
    }
}