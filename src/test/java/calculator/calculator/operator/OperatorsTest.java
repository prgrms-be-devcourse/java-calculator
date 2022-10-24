package calculator.calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorsTest {

    @ParameterizedTest(name = "[{index}] formula = {0}")
    @MethodSource("whenFindNotOperatorThenSuccessDummy")
    @DisplayName("문자 연산자 외 문자 구별 성공 테스트")
    void whenFindNotOperatorThenSuccessTest(String notOperator) {
        boolean checkOperator = Operators.isOperator(notOperator);
        assertThat(checkOperator).isFalse();
    }

    @ParameterizedTest(name = "[{index}] formula = {0}")
    @MethodSource("whenFindOperatorThenSuccessDummy")
    @DisplayName("문자 연산자 구별 성공 테스트")
    void whenFindOperatorThenSuccessTest(String operator) {
        boolean notOperator = Operators.isOperator(operator);
        assertThat(notOperator).isTrue();
    }

    @ParameterizedTest(name = "[{index}] formula = {0} {1} {2}, expect = {3}")
    @MethodSource("whenFindOperatorAndCalculateThenSuccessDummy")
    @DisplayName("문자 연산자 검색 후 연산 성공 테스트")
    void whenFindOperatorAndCalculateThenSuccessTest(double leftOperand,
                                                     String operator,
                                                     double rightOperand,
                                                     String expect) {

        String result = Operators.calculate(
                BigDecimal.valueOf(leftOperand),
                operator,
                BigDecimal.valueOf(rightOperand));

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = {0} compare {1}, expect = {2}")
    @MethodSource("whenFindOperatorAndComparePriorityThenSuccessDummy")
    @DisplayName("문자 연산자 검색 후 우선 순위 비교 성공 테스트")
    void whenFindOperatorAndComparePriorityThenSuccessTest(String leftOperator, String rightOperator, boolean expect) {
        boolean result = Operators.isLeftSameOrMoreImportantThan(leftOperator, rightOperator);
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = {0} compare {1}, expect = {2}")
    @MethodSource("whenFindOperatorAndComparePriorityWrongThenSuccessDummy")
    @DisplayName("문자 연산자 검색 후 우선 순위 잘못된 비교 결과 구별 성공 테스트")
    void whenFindOperatorAndComparePriorityWrongThenSuccessTest(String leftOperator, String rightOperator, boolean expect) {
        boolean result = Operators.isLeftSameOrMoreImportantThan(leftOperator, rightOperator);
        assertThat(result).isNotEqualTo(expect);
    }

    static Stream<Arguments> whenFindNotOperatorThenSuccessDummy() {
        return IntStream.rangeClosed(33, 126)
                .filter(OperatorsTest::checkNotOperator)
                .mapToObj(OperatorsTest::parseToString);
    }

    static Arguments parseToString(int ascii) {
        return Arguments.arguments(String.valueOf((char) ascii));
    }

    static boolean checkNotOperator(int ascii) {
        return !String.valueOf((char) ascii).matches("^[+\\-*/]$");
    }

    static Stream<Arguments> whenFindOperatorThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("+"),
                Arguments.arguments("-"),
                Arguments.arguments("*"),
                Arguments.arguments("/")
        );
    }

    static Stream<Arguments> whenFindOperatorAndCalculateThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(1, "+", 2, "3.0"),
                Arguments.arguments(1, "-", 2, "-1.0"),
                Arguments.arguments(1, "*", 2, "2.00"),
                Arguments.arguments(1, "/", 2, "0.500000000000000"),

                Arguments.arguments(1.1, "+", 2.2, "3.3"),
                Arguments.arguments(1.1, "-", 2.2, "-1.1"),
                Arguments.arguments(1.1, "*", 2.2, "2.42"),
                Arguments.arguments(1.1, "/", 2.2, "0.500000000000000")
        );
    }

    static Stream<Arguments> whenFindOperatorAndComparePriorityThenSuccessDummy() {
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

    static Stream<Arguments> whenFindOperatorAndComparePriorityWrongThenSuccessDummy() {
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