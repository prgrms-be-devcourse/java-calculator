package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PostfixExpressionTest {

    private static Stream<Arguments> providePostfixExpression() {
        return Stream.of(
            Arguments.of(Arrays.asList("1", "3", "2", "/", "+"), 2.5),
            Arguments.of(Arrays.asList("1", "5", "/", "3", "/"), 0.06666666666666667),
            Arguments.of(Arrays.asList("1", "3", "*", "5", "2", "/", "+"), 5.5),
            Arguments.of(Arrays.asList("1.5", "3.5", "*", "5.5", "2", "/", "+"), 8),
            Arguments.of(Arrays.asList("-1", "1", "*"), -1)
        );
    }

    @DisplayName("후위방정식을 주면 계산한다.")
    @ParameterizedTest
    @MethodSource("providePostfixExpression")
    void calculate_expression(List<String> postfix, double expected) {
        PostfixExpression postfixExpression = new PostfixExpression(postfix);
        double result = postfixExpression.calculate();
        assertThat(result).isEqualTo(expected);
    }
}
