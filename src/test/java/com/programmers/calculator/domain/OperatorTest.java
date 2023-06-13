package com.programmers.calculator.domain;

import com.programmers.calculator.exception.InvalidOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperatorTest {
    @ParameterizedTest
    @DisplayName("올바른 연산자인 경우 성공한다.")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 올바른_연산자인_경우(String symbol) {
        assertThatCode(() -> Operator.findBySymbol(symbol))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("잘못된 연산자인 경우 예외가 발생한다.")
    @ValueSource(strings = {"!", "a", ""})
    void 잘못된_연산자인_경우(String symbol) {
        assertThatThrownBy(() -> Operator.findBySymbol(symbol))
                .isInstanceOf(InvalidOperatorException.class);
    }
}
