package com.programmers.blackdog.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.programmers.blackdog.domain.ArithmeticOperators.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArithmeticOperatorsTest {

    @DisplayName("두 수를 더하면 올바른 값이 반환된다.")
    @Test
    void when_AddTwoNum_Expects_correctResult() {
        int result = ADDITION.apply(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("두 수를 빼면 올바른 값이 반환된다.")
    @Test
    void when_SubtractTwoNum_Expects_correctResult() {
        int result = SUBTRACTION.apply(1, 2);
        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("두 수를 곱하면 올바른 값이 반환된다.")
    @Test
    void when_MultiplyTwoNum_Expects_correctResult() {
        int result = MULTIPLICATION.apply(4, 2);
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("두 수를 나누면 올바른 값이 반환된다.")
    @Test
    void when_DivideTwoNum_Expects_correctResult() {
        int result = DIVISION.apply(4, 2);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("0으로 나누면 예외를 발생한다.")
    @Test
    void when_DivideWithZero_Expects_ThrowsException() {
        assertThatThrownBy(() -> DIVISION.apply(10, 0))
                .isInstanceOf(ArithmeticException.class);
    }
}
