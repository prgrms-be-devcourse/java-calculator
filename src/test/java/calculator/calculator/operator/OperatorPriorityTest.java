package calculator.calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorPriorityTest {

    @ParameterizedTest(name = "[{index}] {0} >= {1}, expect = {2}")
    @MethodSource("whenCompareOperatorsPriorityThenSuccessDummy")
    @DisplayName("연산자 연산 우선순위 비교 성공 테스트")
    void whenCompareOperatorPriorityThenSuccessTest(String leftPriority,
                                                    String rightPriority,
                                                    boolean expect) {

        boolean result = Operators.isLeftSameOrMoreImportantThan(leftPriority, rightPriority);
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] {0} >= {1}, expect = {2}")
    @MethodSource("whenCompareOperatorsPriorityThenFailDummy")
    @DisplayName("연산자 연산 우선순위 비교 실패 테스트")
    void whenCompareOperatorPriorityThenFailTest(String leftPriority,
                                                    String rightPriority,
                                                    boolean expect) {

        boolean result = Operators.isLeftSameOrMoreImportantThan(leftPriority, rightPriority);
        assertThat(result).isNotEqualTo(expect);
    }

    static Stream<Arguments> whenCompareOperatorsPriorityThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("+", "+", true),
                Arguments.arguments("+", "-", true),
                Arguments.arguments("+", "/", false),
                Arguments.arguments("+", "*", false),
                Arguments.arguments("-", "+", true),
                Arguments.arguments("-", "-", true),
                Arguments.arguments("-", "/", false),
                Arguments.arguments("-", "*", false),
                Arguments.arguments("*", "+", true),
                Arguments.arguments("*", "-", true),
                Arguments.arguments("*", "/", true),
                Arguments.arguments("*", "*", true),
                Arguments.arguments("/", "+", true),
                Arguments.arguments("/", "-", true),
                Arguments.arguments("/", "/", true),
                Arguments.arguments("/", "*", true)
        );
    }

    static Stream<Arguments> whenCompareOperatorsPriorityThenFailDummy() {
        return Stream.of(
                Arguments.arguments("+", "+", false),
                Arguments.arguments("+", "-", false),
                Arguments.arguments("+", "/", true),
                Arguments.arguments("+", "*", true),
                Arguments.arguments("-", "+", false),
                Arguments.arguments("-", "-", false),
                Arguments.arguments("-", "/", true),
                Arguments.arguments("-", "*", true),
                Arguments.arguments("*", "+", false),
                Arguments.arguments("*", "-", false),
                Arguments.arguments("*", "/", false),
                Arguments.arguments("*", "*", false),
                Arguments.arguments("/", "+", false),
                Arguments.arguments("/", "-", false),
                Arguments.arguments("/", "/", false),
                Arguments.arguments("/", "*", false)
        );
    }
}