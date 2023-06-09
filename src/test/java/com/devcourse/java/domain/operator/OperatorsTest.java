package com.devcourse.java.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.devcourse.java.domain.operator.Operators.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.*;

class OperatorsTest {

    @ParameterizedTest
    @DisplayName("연산자의 우선순위가 맞게 출력되야 한다.")
    @MethodSource("data")
    void operatorPriorityTest(String symbol, int priority) {
        // given

        // when
        int evaluatedPriority = evaluatePriority(symbol);

        // then
        assertThat(evaluatedPriority).isEqualTo(priority);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("+", PLUS.getPriority()),
                arguments("-", MINUS.getPriority()),
                arguments("*", MULTIPLY.getPriority()),
                arguments("/", DIVIDE.getPriority())
        );
    }
}
