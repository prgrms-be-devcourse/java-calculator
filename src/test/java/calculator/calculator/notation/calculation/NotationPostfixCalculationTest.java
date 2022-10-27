package calculator.calculator.notation.calculation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static calculator.exception.NotationException.NOTATION_POSTFIX_NULL_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NotationPostfixCalculationTest {

    private final NotationPostfixCalculation notationPostfixCalculation = new NotationPostfixCalculation();

    @ParameterizedTest(name = "[{index}] : formula = {0}, expect = {1}")
    @MethodSource("whenCalculatePostfixNotationThenSuccessDummy")
    @DisplayName("후위 표기식 연산 성공 테스트")
    void whenCalculatePostfixNotationThenSuccessTest(List<String> notation, String expect) {
        String result = notationPostfixCalculation.calculate(notation).toString();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] : notation = {0}")
    @MethodSource("whenCalculatePostfixNotationThenExceptionDummy")
    @DisplayName("후위 표기법 연산 오류 예외처리 테스트")
    void whenCalculatePostfixNotationThenExceptionTest(List<String> notation) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> notationPostfixCalculation.calculate(notation))
                .withMessageMatching(NOTATION_POSTFIX_NULL_EXCEPTION.getMessage());
    }

    static Stream<Arguments> whenCalculatePostfixNotationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(List.of("0", "0", "+"), "0"),
                Arguments.arguments(List.of("1", "2", "+"), "3"),
                Arguments.arguments(List.of("1", "2", "-"), "-1"),
                Arguments.arguments(List.of("1", "2", "*"), "2"),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "+", "5", "+"), "15"),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "+", "5", "-"), "5"),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "5", "*", "+"), "26"),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "5", "/", "+"), "6.800000000000000"),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "-", "5", "+"), "7"),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "*", "+", "5", "+"), "20"),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "/", "+", "5", "+"), "8.750000000000000"),
                Arguments.arguments(List.of("1", "2", "+", "3", "-", "4", "+", "5", "+"), "9"),
                Arguments.arguments(List.of("1", "2", "3", "*", "+", "4", "+", "5", "+"), "16"),
                Arguments.arguments(List.of("1", "2", "3", "/", "+", "4", "+", "5", "+"), "10.666666666666667"),
                Arguments.arguments(List.of("1", "2", "-", "3", "+", "4", "+", "5", "+"), "11"),
                Arguments.arguments(List.of("1", "2", "*", "3", "+", "4", "+", "5", "+"), "14"),
                Arguments.arguments(List.of("1", "2", "/", "3", "+", "4", "+", "5", "+"), "12.500000000000000"),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "-", "5", "-"), "-3"),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "5", "*", "-"), "-14"),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "5", "/", "-"), "5.200000000000000"),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "*", "+", "5", "-"), "10"),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "*", "+", "5", "/"), "3.000000000000000"),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "*", "+", "5", "*"), "75"),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "/", "+", "5", "-"), "-1.250000000000000"),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "/", "+", "5", "*"), "18.750000000000000"),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "/", "+", "5", "/"), "0.750000000000000")
        );
    }

    static Stream<Arguments> whenCalculatePostfixNotationThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments(List.of("0", "+")),
                Arguments.arguments(List.of("1", "+")),
                Arguments.arguments(List.of("1", "-")),
                Arguments.arguments(List.of("1", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "*", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "*", "/")),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "-", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "*", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "/", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "-", "4", "+", "*")),
                Arguments.arguments(List.of("1", "2", "3", "*", "+", "4", "+", "*")),
                Arguments.arguments(List.of("1", "2", "3", "/", "+", "4", "+", "*")),
                Arguments.arguments(List.of("1", "2", "-", "3", "+", "4", "+", "*")),
                Arguments.arguments(List.of("1", "2", "*", "3", "+", "4", "+", "*")),
                Arguments.arguments(List.of("1", "2", "/", "3", "+", "4", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "-", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "*", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "+", "4", "*", "/")),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "*", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "*", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "*", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "/", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "/", "+", "*")),
                Arguments.arguments(List.of("1", "2", "+", "3", "4", "/", "+", "*"))
        );
    }
}