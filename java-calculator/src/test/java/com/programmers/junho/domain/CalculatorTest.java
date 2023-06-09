package com.programmers.junho.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("계산 결과 테스트")
    @ParameterizedTest(name = "식: {0}, 결과: {1}")
    @CsvSource(value = {"1 + 2:3", "1 + 2 * 3:7", "3 - 2 * 2:-1", "44 / 2 * 8:176", "22 * 8:176", "12 + 44 / 2 * 8 - 10 + 18 / 2 / 3:181"}, delimiter = ':')
    void when_ExpressionIsGiven_CalculateCorrectResult(String expression, int calculatedResult) {
        Calculator calculator = new Calculator(expression);

        int actual = calculator.calculate();

        assertThat(actual).isEqualTo(calculatedResult);
    }

    @DisplayName("정수 형 값을 벗어났을 경우 예외 발생")
    @ParameterizedTest(name = "식: {0}")
    @ValueSource(strings = {"999999 * 999999 * 99999 * 9999999","1 - 999999999 - 999999999 - 999999999 - 999999999"})
    void when_CalculatedResultIsOutOfIntegerRange_Expects_ThrowException(String expression) {
        assertThatThrownBy(() -> new Calculator(expression).calculate())
                .isInstanceOf(ArithmeticException.class);
    }

    @DisplayName("입력값이 정수 범위를 초과하면 예외를 발생한다.")
    @Test
    void when_InputIsOutOfIntegerRange_Expects_ThrowException() {
        Calculator calculator = new Calculator("999999999999999 + 1");
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }
}