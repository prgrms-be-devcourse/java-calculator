package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

    Calculator calculator;

    private static Stream<Arguments> provideNormalExpression() {
        return Stream.of(
            Arguments.of(Arrays.asList("1", "2", "*"), "2"),
            Arguments.of(Arrays.asList("4", "5", "2", "/", "*"), "10"),
            Arguments.of(Arrays.asList("1", "2", "3", "*", "+", "4", "5", "/", "-"), "6.20")
        );
    }

    private static Stream<Arguments> provideWrongExpression() {
        return Stream.of(
            Arguments.of(Arrays.asList("+", "1")),
            Arguments.of(Arrays.asList("4", "5", "2", "/", "*", "3")),
            Arguments.of(Arrays.asList("1", "2", "3", "*", "+", "4", "5", "/", "-", "/")),
            Arguments.of(Arrays.asList("0", "1", "/", "*", "+", "4", "5", "/", "-", "/"))
        );
    }

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName("정상적인 후위표기식을 주면 계산한다.")
    @ParameterizedTest
    @MethodSource("provideNormalExpression")
    void calculate_expression(List<String> input, double expected) {
        double result = calculator.calculateExpression(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("잘못된 후위표기식을 주면 에러를 발생한다.")
    @ParameterizedTest
    @MethodSource("provideWrongExpression")
    void calculate_expression(List<String> input) {
        assertThatThrownBy(() -> calculator.calculateExpression(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }
}
