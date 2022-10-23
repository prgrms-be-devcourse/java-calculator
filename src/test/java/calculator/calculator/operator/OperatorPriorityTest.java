package calculator.calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.calculator.operator.OperatorPriority.*;
import static org.assertj.core.api.Assertions.assertThat;

class OperatorPriorityTest {

    @ParameterizedTest(name = "[{index}] {0} >= {1}, expect = {2}")
    @MethodSource("whenCompareOperatorsPriorityThenSuccessDummy")
    @DisplayName("연산자 연산 우선순위 비교 성공 테스트")
    void whenCompareOperatorPriorityThenSuccessTest(OperatorPriority leftPriority,
                                                    OperatorPriority rightPriority,
                                                    boolean expect) {

        boolean result = isLeftSameOrMoreImportantThanRight(leftPriority, rightPriority);
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] {0} >= {1}, expect = {2}")
    @MethodSource("whenCompareOperatorsPriorityThenFailDummy")
    @DisplayName("연산자 연산 우선순위 비교 실패 테스트")
    void whenCompareOperatorPriorityThenFailTest(OperatorPriority leftPriority,
                                                    OperatorPriority rightPriority,
                                                    boolean expect) {

        boolean result = isLeftSameOrMoreImportantThanRight(leftPriority, rightPriority);
        assertThat(result).isNotEqualTo(expect);
    }

    static Stream<Arguments> whenCompareOperatorsPriorityThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(PLUS_PRIORITY, PLUS_PRIORITY, true),
                Arguments.arguments(PLUS_PRIORITY, MINUS_PRIORITY, true),
                Arguments.arguments(PLUS_PRIORITY, DIVIDE_PRIORITY, false),
                Arguments.arguments(PLUS_PRIORITY, MULTIPLY_PRIORITY, false),
                Arguments.arguments(MINUS_PRIORITY, PLUS_PRIORITY, true),
                Arguments.arguments(MINUS_PRIORITY, MINUS_PRIORITY, true),
                Arguments.arguments(MINUS_PRIORITY, DIVIDE_PRIORITY, false),
                Arguments.arguments(MINUS_PRIORITY, MULTIPLY_PRIORITY, false),
                Arguments.arguments(MULTIPLY_PRIORITY, PLUS_PRIORITY, true),
                Arguments.arguments(MULTIPLY_PRIORITY, MINUS_PRIORITY, true),
                Arguments.arguments(MULTIPLY_PRIORITY, DIVIDE_PRIORITY, true),
                Arguments.arguments(MULTIPLY_PRIORITY, MULTIPLY_PRIORITY, true),
                Arguments.arguments(DIVIDE_PRIORITY, PLUS_PRIORITY, true),
                Arguments.arguments(DIVIDE_PRIORITY, MINUS_PRIORITY, true),
                Arguments.arguments(DIVIDE_PRIORITY, DIVIDE_PRIORITY, true),
                Arguments.arguments(DIVIDE_PRIORITY, MULTIPLY_PRIORITY, true)
        );
    }

    static Stream<Arguments> whenCompareOperatorsPriorityThenFailDummy() {
        return Stream.of(
                Arguments.arguments(PLUS_PRIORITY, PLUS_PRIORITY, false),
                Arguments.arguments(PLUS_PRIORITY, MINUS_PRIORITY, false),
                Arguments.arguments(PLUS_PRIORITY, DIVIDE_PRIORITY, true),
                Arguments.arguments(PLUS_PRIORITY, MULTIPLY_PRIORITY, true),
                Arguments.arguments(MINUS_PRIORITY, PLUS_PRIORITY, false),
                Arguments.arguments(MINUS_PRIORITY, MINUS_PRIORITY, false),
                Arguments.arguments(MINUS_PRIORITY, DIVIDE_PRIORITY, true),
                Arguments.arguments(MINUS_PRIORITY, MULTIPLY_PRIORITY, true),
                Arguments.arguments(MULTIPLY_PRIORITY, PLUS_PRIORITY, false),
                Arguments.arguments(MULTIPLY_PRIORITY, MINUS_PRIORITY, false),
                Arguments.arguments(MULTIPLY_PRIORITY, DIVIDE_PRIORITY, false),
                Arguments.arguments(MULTIPLY_PRIORITY, MULTIPLY_PRIORITY, false),
                Arguments.arguments(DIVIDE_PRIORITY, PLUS_PRIORITY, false),
                Arguments.arguments(DIVIDE_PRIORITY, MINUS_PRIORITY, false),
                Arguments.arguments(DIVIDE_PRIORITY, DIVIDE_PRIORITY, false),
                Arguments.arguments(DIVIDE_PRIORITY, MULTIPLY_PRIORITY, false)
        );
    }
}