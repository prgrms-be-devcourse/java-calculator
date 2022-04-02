package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PostfixExpressionTest {

    private static Stream<Arguments> provideNormalExpression() {
        return Stream.of(
            Arguments.of("1 + 3 / 2", 2.5),
            Arguments.of("1 / 5 / 2", 0.1),
            Arguments.of("1 * 3 + 5 / 2", 5.5),
            Arguments.of("1.5 * 3.5 + 5.5 / 2.0", 8),
            Arguments.of("-1.5 * 3.5 + -3.25 / 0.5", -11.75)
        );
    }

    @DisplayName("정상적인 식을 주면 계산한다.")
    @ParameterizedTest
    @MethodSource("provideNormalExpression")
    void calculate_expression(String postfix, double expected) {
        PostfixExpression postfixExpression = PostfixExpression.from(postfix);
        double result = postfixExpression.calculate();
        assertThat(result).isEqualTo(expected);
    }
}
