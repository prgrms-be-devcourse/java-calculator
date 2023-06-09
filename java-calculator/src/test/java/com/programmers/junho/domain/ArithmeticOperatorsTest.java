package com.programmers.junho.domain;

import org.junit.jupiter.api.Test;

import static com.programmers.junho.domain.ArithmeticOperators.*;
import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticOperatorsTest {

    @Test
    void add() {
        double result = ADDITION.apply(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        double result = SUBTRACTION.apply(1, 2);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void multiply() {
        double result = MULTIPLICATION.apply(2, 4);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void divide() {
        double result = DIVISION.apply(4, 2);
        assertThat(result).isEqualTo(2);
    }
}
