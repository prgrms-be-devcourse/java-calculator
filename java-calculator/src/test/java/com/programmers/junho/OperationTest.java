package com.programmers.junho;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @Test
    void add() {
        Operation operation = new Operation();
        int result = operation.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        Operation operation = new Operation();
        int result = operation.subtract(1, 2);
        assertThat(result).isEqualTo(-1);
    }
}
