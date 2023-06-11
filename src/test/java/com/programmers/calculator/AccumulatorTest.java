package com.programmers.calculator;

import com.programmers.converter.InfixToPostfixConverter;
import com.programmers.converter.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AccumulatorTest {

    Accumulator accumulator;

    @BeforeEach
    void setUp() {
        accumulator = new Accumulator(new InfixToPostfixConverter());
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 3 : 4", "10 + 5 : 15", "15 + 2 + 17 : 34"}, delimiter = ':')
    @DisplayName("덧셈연산")
    void add(String input, String output) {
        assertThat(accumulator.calculate(input).get()).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 3 : -2", "17 - 5 - 9 : 3", "523 - 18 - 9 : 496"}, delimiter = ':')
    @DisplayName("뺄셈연산")
    void subtract(String input, String output) {
        assertThat(accumulator.calculate(input).get()).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 3 : 3", "17 * 5 * 9 : 765", "523 * 18 * 9 : 84726"}, delimiter = ':')
    @DisplayName("곱셈연산")
    void multiply(String input, String output) {
        assertThat(accumulator.calculate(input).get()).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 / 3 : 0.3333333333", "17 / 5 / 2 : 1.7", "523 / 18 / 9 : 3.2283950617"}, delimiter = ':')
    @DisplayName("나눗셈연산")
    void divide(String input, String output) {
        assertThat(accumulator.calculate(input).get()).isEqualTo(output);
    }

    @Test
    @DisplayName("0으로 나누는 경우에 대한 예외 처리")
    void divide0Exception() {
        assertThatThrownBy(() -> Operator.DIVIDE.operation(BigDecimal.TEN, BigDecimal.ZERO))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"3 * 8 / 4 : 6", "( 3 / ( 8 - 4 + 9 ) ) * ( 20 - 8 ) * 17 : 47.0769230769 ", "10/7-15+10*20-5*8 : 146.4285714285"}, delimiter = ':')
    @DisplayName("사칙연산")
    void 사칙연산(String input, String output) {
        assertThat(accumulator.calculate(input).get()).isEqualTo(output);
    }
}