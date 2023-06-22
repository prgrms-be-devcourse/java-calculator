package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    @DisplayName("0으로 나눌 경우 예외 발생")
    void throwArithmeticExceptionIfDivideByZero() {
        // when, then
        assertThatThrownBy(() -> Operator.DIVIDE.applyCalculate(10, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("[ERROR] 0으로 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("덧셈연산 테스트")
    void checkPlusOperationValid() {
        // when
        int actual = Operator.PLUS.applyCalculate(3, 4);
        // then
        assertThat(actual).isEqualTo(7);
    }

    @Test
    @DisplayName("뺄셈연산 테스트")
    void checkMinusOperationValid() {
        // when
        int actual = Operator.MINUS.applyCalculate(3, 4);
        // then
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈연산 테스트")
    void checkMultiplyOperationValid() {
        // when
        int actual = Operator.MULTIPLY.applyCalculate(3, 4);
        // then
        assertThat(actual).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈연산 테스트")
    void checkDivideOperationValid() {
        // when
        int actual = Operator.DIVIDE.applyCalculate(3, 4);
        // then
        assertThat(actual).isEqualTo(0);
    }
}
