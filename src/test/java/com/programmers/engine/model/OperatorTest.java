package com.programmers.engine.model;

import com.programmers.engine.model.operation.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class OperatorTest {

    @Test
    void 더하기_연산_테스트() {
        Integer result = Operator.getOperator("+").calculate(4, 2);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 빼기_연산_테스트() {
        Integer result = Operator.getOperator("-").calculate(4, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 곱하기_연산_테스트() {
        Integer result = Operator.getOperator("*").calculate(4, 2);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void 나누기_연산_테스트() {
        Integer result = Operator.getOperator("/").calculate(4, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 잘못된_연산자_입력시_예외_테스트() {
        String input = "=";
        assertThatThrownBy(()->Operator.getOperator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}