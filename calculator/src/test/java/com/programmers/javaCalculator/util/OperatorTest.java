package com.programmers.javaCalculator.util;

import com.programmers.javaCalulator.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Operator enum class 에는 요구 사항 명서세에서 제시된 +, -, *, / 연산자가 기본값으로 정의되어 있다.
 */
class OperatorTest {

    @Test
    @DisplayName("정의된 연산자와 피연자의 연산 결과 반환")
    void getResultTest() {
        //요구 조건에 따라 미리 정의된 사칙 연산
        assertThat(com.programmers.javaCalulator.util.Operator.getResult("+", 15, 13))
                .isEqualTo(28);
        assertThat(com.programmers.javaCalulator.util.Operator.getResult("-", 13, 15))
                .isEqualTo(-2);
        assertThat(com.programmers.javaCalulator.util.Operator.getResult("*", 2, 5))
                .isEqualTo(10);
        assertThat(com.programmers.javaCalulator.util.Operator.getResult("/", 15, 13))
                .isEqualTo(1);
        assertThat(com.programmers.javaCalulator.util.Operator.getResult("/", 13, 15))
                .isEqualTo(0);

        //0으로 나눌 경우 예외 발생
        assertThatThrownBy(() -> com.programmers.javaCalulator.util.Operator.getResult("/", 13, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage(ExceptionMessage.DIVIDED_BY_ZERO);
    }

    @Test
    @DisplayName("정의된 연산자에 대응하는 우선순위 반환")
    void getPrecedenceTest() {
        assertThat(com.programmers.javaCalulator.util.Operator.getPrecedence("*")).isEqualTo(2);
        assertThat(com.programmers.javaCalulator.util.Operator.getPrecedence("+")).isEqualTo(3);
        assertThat(com.programmers.javaCalulator.util.Operator.getPrecedence("/")).isEqualTo(2);
        assertThat(com.programmers.javaCalulator.util.Operator.getPrecedence("-")).isEqualTo(3);
    }

    @Test
    @DisplayName("입력받은 값이 정의된 연산자인지 검증")
    void isOperatorTest() {
        /* 정의된 연산자일 경우 */
        assertThat(com.programmers.javaCalulator.util.Operator.isOperator("+")).isEqualTo(true);
        assertThat(com.programmers.javaCalulator.util.Operator.isOperator("/")).isEqualTo(true);
        assertThat(com.programmers.javaCalulator.util.Operator.isOperator("*")).isEqualTo(true);
        assertThat(com.programmers.javaCalulator.util.Operator.isOperator("-")).isEqualTo(true);

        /* 정의되지 않은 연산자일 경우 */
        assertThat(com.programmers.javaCalulator.util.Operator.isOperator("ㅁ")).isEqualTo(false);
        assertThat(com.programmers.javaCalulator.util.Operator.isOperator("1")).isEqualTo(false);
        assertThat(com.programmers.javaCalulator.util.Operator.isOperator("a")).isEqualTo(false);
        assertThat(com.programmers.javaCalulator.util.Operator.isOperator("%")).isEqualTo(false);
    }

}