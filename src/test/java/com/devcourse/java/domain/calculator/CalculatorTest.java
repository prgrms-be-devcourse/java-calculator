package com.devcourse.java.domain.calculator;

import com.devcourse.java.domain.operator.OperatorMapper;
import com.devcourse.java.domain.calculator.parser.PrefixParser;
import com.devcourse.java.domain.storage.CalculateResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTest {
    private final PrefixParser parser = new PrefixParser();
    private final OperatorMapper factory = new OperatorMapper();
    private final PrefixCalculator prefixCalculator = new PrefixCalculator(parser, factory);

    @ParameterizedTest
    @DisplayName("계산을 시키면 입력에 따른 예상값이 정상적으로 계산되야 한다.")
    @MethodSource("test")
    void runCalculateTest(String expression, int expected) {
        // given

        // when
        CalculateResult result = prefixCalculator.run(expression);

        // then
        assertThat(result.getExpression()).isEqualTo(expression);
        assertThat(result.getResult()).isEqualTo(expected);
    }

    private static Stream<Arguments> test() {
        return Stream.of(
                arguments("3 + 4 * 2", 11),
                arguments("8 - 6 / 2", 5),
                arguments("5 * 2 + 7 - 1", 16)
        );
    }
}
