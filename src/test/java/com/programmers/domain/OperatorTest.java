package com.programmers.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void 입력된_값에_맞는_연산자를_찾는다() {
        //given
        //when
        Operator operator = Operator.findOperator("+");

        //then
        assertThat(operator).isEqualTo(Operator.ADDITION);
    }

    @Test
    void 입력된_연산자의_우선순위를_찾는다() {
        //given
        //when
        int result = Operator.findImportance("*");

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 연산자에_맞는_계산을_수행한다() {
        //given
        //when
        int result = Operator.MULTIPLICATION.calculate(2, 10);

        //then
        assertThat(result).isEqualTo(20);
    }
}