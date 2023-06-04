package com.javacalculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    void 사칙연산_기호가_아닌_기호를_입력하면_예외가_발생한다() {
        // given
        String symbol = "&";

        // when & then
        assertThatThrownBy(() -> Operator.from(symbol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 기호는 사칙연산 기호가 아닙니다. : " + symbol);
    }

    @ParameterizedTest(name = "[{index}] 6 {0} 2 = {1}")
    @CsvSource(value = {"+:8", "-:4", "*:12", "/:3"}, delimiter = ':')
    void 사칙연산을_한다(String symbol, int expected) {
        // given
        Operator operator = Operator.from(symbol);

        // when
        int result = operator.operate(6, 2);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
