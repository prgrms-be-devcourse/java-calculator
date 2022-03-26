package calculator.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ExpressionParserTest {

    Parser parser;

    private static Stream<Arguments> provideExpression() { // argument source method
        return Stream.of(
            Arguments.of("1 + 3 / 2", Arrays.asList("1", "3", "2", "/", "+")),
            Arguments.of("1 / 5 / 3", Arrays.asList("1", "5", "/", "3", "/")),
            Arguments.of("1 * 3 + 5 / 2", Arrays.asList("1", "3", "*", "5", "2", "/", "+"))
        );
    }

    @BeforeEach
    void setup() {
        parser = new ExpressionParser(" ");
    }

    @DisplayName("입력받은 식을 후위표기식으로 변환한다.")
    @ParameterizedTest
    @MethodSource("provideExpression")
    void parse_postfix(String input, List<String> expected) {
        List<String> result = parser.parsePostfix(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력된 값이 공백이거나 null이면 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void parse_blankOrNull_throwException(String input) {
        assertThatThrownBy(() -> parser.parsePostfix(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.");
    }
}
