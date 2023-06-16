package com.programmers.calculator.domain;

import com.programmers.calculator.exception.InvalidExpressionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionTest {
    @Test
    @DisplayName("수식 포맷팅에 성공한다.")
    void 수식_포맷팅() {
        // given
        String expression = "2 +   30/3 ";
        // when
        Expression result = new Expression(expression);
        // then
        assertThat(result.getValue()).isEqualTo("2 + 30 / 3");
    }

    @Test
    @DisplayName("잘못된 수식인 경우 예외가 발생한다.")
    void 잘못된_수식_형식_예외() {
        // given
        String expression = "2 + - 8 / ";
        // when
        InvalidExpressionException e = assertThrows(InvalidExpressionException.class,
                () -> new Expression(expression));
        // then
        assertThat(e.getMessage()).isEqualTo("올바르지 않은 수식입니다.");
    }

    @Test
    @DisplayName("0으로 나누는 경우 예외가 발생한다.")
    void 나누기_0_예외() {
        // given
        String expression = "2 + 8 / 0";
        // when
        InvalidExpressionException e = assertThrows(InvalidExpressionException.class,
                () -> new Expression(expression));
        // then
        assertThat(e.getMessage()).isEqualTo("0으로 나눌 수 없습니다.");
    }
}
