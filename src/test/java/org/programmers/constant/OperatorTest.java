package org.programmers.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    @DisplayName("더하기 성공 테스트")
    void addSuccessTest() {
        double result = Operator.PLUS.getAnswer(3, 4);
        assertThat(result).isEqualTo(7.0);
    }

    @Test
    @DisplayName("빼기 성공 테스트")
    void subtractSuccessTest() {
        double result = Operator.MINUS.getAnswer(3, 4);
        assertThat(result).isEqualTo(1.0);
    }

    @Test
    @DisplayName("곱하기 성공 테스트")
    void multiplySuccessTest() {
        double result = Operator.MULTI.getAnswer(3, 4);
        assertThat(result).isEqualTo(12.0);
    }

    @Test
    @DisplayName("나누기 성공 테스트")
    void divideSuccessTest() {
        double result = Operator.DIVISION.getAnswer(4, 3);
        assertThat(result).isEqualTo(0.75);
    }

    @Test
    @DisplayName("0으로 나누면 예외가 발생한다.")
    void divideExceptionTest() {
        assertThatThrownBy(() -> Operator.DIVISION.getAnswer(0, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}