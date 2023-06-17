package com.programmers.engine.model;

import com.programmers.engine.model.operation.Operation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OperationTest {

    @Test
    void 입력된_수식_계산() {
        String input = "1 + 2 * 3 - 4 / 2";
        Integer result = Operation.calculate(input);
        Assertions.assertThat(result).isEqualTo(5);
    }
}