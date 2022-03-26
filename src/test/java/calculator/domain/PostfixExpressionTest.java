package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PostfixExpressionTest {

    private static Stream<Arguments> provideNormalExpression() {
        return Stream.of(
            Arguments.of("1 + 3 / 2", Arrays.asList("1", "3", "2", "/", "+")),
            Arguments.of("1 / 5 / 3", Arrays.asList("1", "5", "/", "3", "/")),
            Arguments.of("1 * 3 + 5 / 2", Arrays.asList("1", "3", "*", "5", "2", "/", "+")),
            Arguments.of("1.5 * 3.5 + 5.5 / 2.012", Arrays.asList("1.5", "3.5", "*", "5.5", "2.012", "/", "+"))
        );
    }

    @DisplayName("from은 식을 주면 Expression 인스턴스를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 2", "4 / 2 * 5", "3 * 2 + 1 - 4 / 5"})
    void from_expression_returnExpressionInstance(String input) {
        assertThat(PostfixExpression.from(input))
            .isInstanceOf(PostfixExpression.class);
    }

    @DisplayName("from은 잘못된 식을 주면 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "4 // 2 * 5", "+ 3 * 2 + 1 - 4 / 5", "1 + 3 / 2 ㅁ", "1.5 * 3.5 + 5.5 / 2.012ㅇㄴㅁ"})
    void from_wrongExpression_throwException(String input) {
        assertThatThrownBy(() -> PostfixExpression.from(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("정상적인 식을 주면 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"1 * 2,2", "4 / 2 * 5,10", "3 * 2 + 1 - 4 / 5,6.20"})
    void calculate_expression(String input, double expected) {
        double result = PostfixExpression.from(input).calculate();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력받은 식을 후위표기식으로 변환한다.")
    @ParameterizedTest
    @MethodSource("provideNormalExpression")
    void parse_expression_to_postfix(String input, List<String> expected) throws
        NoSuchFieldException,
        IllegalAccessException {
        PostfixExpression postfixExpression = PostfixExpression.from(input);
        Field result = postfixExpression.getClass().getDeclaredField("expression");
        result.setAccessible(true);
        assertThat(result.get(postfixExpression)).isEqualTo(expected);
    }

    @DisplayName("입력된 값이 공백이거나 null이면 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void parse_blankOrNull_throwException(String input) {
        assertThatThrownBy(() -> PostfixExpression.from(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.");
    }
}
