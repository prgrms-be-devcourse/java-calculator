package com.programmers.domain;

import com.programmers.exception.InvalidExpressionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionTest {
    @Test
    @DisplayName("잘못된 수식인 경우 예외가 발생한다.")
    void 잘못된_수식_형식_예외() {
        // given
        String expression = "2 + -8/";
        // when
        InvalidExpressionException e = assertThrows(InvalidExpressionException.class,
                () -> new Expression(expression));
        // then
        assertThat(e.getMessage()).isEqualTo("올바르지 않은 수식입니다.");
    }
}
