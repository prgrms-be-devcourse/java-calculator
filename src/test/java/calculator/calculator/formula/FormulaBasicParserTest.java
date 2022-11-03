package calculator.calculator.formula;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static calculator.exception.FormulaException.FORMULA_BASIC_NULL_EXCEPTION;
import static calculator.exception.FormulaException.FORMULA_BASIC_PARSER_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FormulaBasicParserTest {

    private final FormulaBasicParser parser = new FormulaBasicParser();

    @ParameterizedTest(name = "[{index}] : formula = {0}, expect = {1}")
    @MethodSource(value = "whenIntegerFormulaThenSuccessDummy")
    @DisplayName("정수 연산식 기본 파싱 성공 테스트")
    void whenIntegerFormulaThenSuccessTest(String formula, List<String> answerFormulas) {
        List<String> parsedFormulas = parser.parseFrom(formula).getFormulaPieces();
        assertThat(parsedFormulas).containsExactlyElementsOf(answerFormulas);
    }

    @ParameterizedTest(name = "[{index}] : formula = {0}, expect = {1}")
    @MethodSource(value = "whenDoubleFormulaThenSuccessDummy")
    @DisplayName("소수 연산식 기본 파싱 성공 테스트")
    void whenDoubleFormulaThenSuccessTest(String formula, List<String> answerFormulas) {
        List<String> parsedFormulas = parser.parseFrom(formula).getFormulaPieces();
        assertThat(parsedFormulas).containsExactlyElementsOf(answerFormulas);
    }

    @ParameterizedTest(name = "[{index}] : formula = {0}, expect = {1}")
    @MethodSource(value = "whenIntegerAndDoubleFormulaThenSuccessDummy")
    @DisplayName("정수, 소수 복합 연산식 기본 파싱 성공 테스트")
    void whenIntegerAndDoubleFormulaThenSuccessTest(String formula, List<String> answerFormulas) {
        List<String> parsedFormulas = parser.parseFrom(formula).getFormulaPieces();
        assertThat(parsedFormulas).containsExactlyElementsOf(answerFormulas);
    }

    @ParameterizedTest(name = "[{index}] : formula = {0}")
    @MethodSource(value = "whenUnreadableFormulaThenExceptionDummy")
    @DisplayName("잘못된 연산식 기본 파싱 실패 예외처리 테스트")
    void whenUnreadableFormulaThenExceptionTest(String formula) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> parser.parseFrom(formula))
                .withMessageMatching(FORMULA_BASIC_NULL_EXCEPTION.getMessage());
    }
    @ParameterizedTest(name = "[{index}] : formula = {0}")
    @MethodSource(value = "whenWrongFormulaThenExceptionDummy")
    @DisplayName("연산식 내 잘못된 문자 파싱 실패 예외처리 테스트")
    void whenWrongFormulaThenExceptionTest(String formula) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> parser.parseFrom(formula))
                .withMessageMatching(FORMULA_BASIC_PARSER_EXCEPTION.getMessage());
    }

    static Stream<Arguments> whenIntegerFormulaThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("1", List.of("1")),
                Arguments.arguments("1 + 1", List.of("1", "+", "1")),
                Arguments.arguments("1 - 1", List.of("1", "-", "1")),
                Arguments.arguments("1 * 1", List.of("1", "*", "1")),
                Arguments.arguments("1 / 1", List.of("1", "/", "1")),
                Arguments.arguments("1 + 2 + 3", List.of("1", "+", "2", "+", "3")),
                Arguments.arguments("1 - 2 - 3", List.of("1", "-", "2", "-", "3")),
                Arguments.arguments("1 * 2 * 3", List.of("1", "*", "2", "*", "3")),
                Arguments.arguments("1 / 2 / 3", List.of("1", "/", "2", "/", "3")),
                Arguments.arguments("1 + 2 + 3", List.of("1", "+", "2", "+", "3")),
                Arguments.arguments("1 + 2 - 3", List.of("1", "+", "2", "-", "3")),
                Arguments.arguments("1 + 2 * 3", List.of("1", "+", "2", "*", "3")),
                Arguments.arguments("1 + 2 / 3", List.of("1", "+", "2", "/", "3")),
                Arguments.arguments("10 + 20 + 30", List.of("10", "+", "20", "+", "30")),
                Arguments.arguments("10 - 20 - 30", List.of("10", "-", "20", "-", "30")),
                Arguments.arguments("10 * 20 * 30", List.of("10", "*", "20", "*", "30")),
                Arguments.arguments("10 / 20 / 30", List.of("10", "/", "20", "/", "30")),
                Arguments.arguments("10 + 20 + 30", List.of("10", "+", "20", "+", "30")),
                Arguments.arguments("10 + 20 - 30", List.of("10", "+", "20", "-", "30")),
                Arguments.arguments("10 + 20 * 30", List.of("10", "+", "20", "*", "30")),
                Arguments.arguments("10 + 20 / 30", List.of("10", "+", "20", "/", "30")),
                Arguments.arguments("100 + 200 + 300", List.of("100", "+", "200", "+", "300")),
                Arguments.arguments("100 - 200 - 300", List.of("100", "-", "200", "-", "300")),
                Arguments.arguments("100 * 200 * 300", List.of("100", "*", "200", "*", "300")),
                Arguments.arguments("100 / 200 / 300", List.of("100", "/", "200", "/", "300")),
                Arguments.arguments("100 + 200 + 300", List.of("100", "+", "200", "+", "300")),
                Arguments.arguments("100 + 200 - 300", List.of("100", "+", "200", "-", "300")),
                Arguments.arguments("100 + 200 * 300", List.of("100", "+", "200", "*", "300")),
                Arguments.arguments("100 + 200 / 300", List.of("100", "+", "200", "/", "300"))
        );
    }

    static Stream<Arguments> whenDoubleFormulaThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("1.1", List.of("1.1")),
                Arguments.arguments("1.1 + 1.1", List.of("1.1", "+", "1.1")),
                Arguments.arguments("1.1 - 1.1", List.of("1.1", "-", "1.1")),
                Arguments.arguments("1.1 * 1.1", List.of("1.1", "*", "1.1")),
                Arguments.arguments("1.1 / 1.1", List.of("1.1", "/", "1.1")),
                Arguments.arguments("1.123 + 2.123 + 3.123", List.of("1.123", "+", "2.123", "+", "3.123")),
                Arguments.arguments("1.123 - 2.123 - 3.123", List.of("1.123", "-", "2.123", "-", "3.123")),
                Arguments.arguments("1.123 * 2.123 * 3.123", List.of("1.123", "*", "2.123", "*", "3.123")),
                Arguments.arguments("1.123 / 2.123 / 3.123", List.of("1.123", "/", "2.123", "/", "3.123")),
                Arguments.arguments("1.123 + 2.123 + 3.123", List.of("1.123", "+", "2.123", "+", "3.123")),
                Arguments.arguments("1.123 + 2.123 - 3.123", List.of("1.123", "+", "2.123", "-", "3.123")),
                Arguments.arguments("1.123 + 2.123 * 3.123", List.of("1.123", "+", "2.123", "*", "3.123")),
                Arguments.arguments("1.123 + 2.123 / 3.123", List.of("1.123", "+", "2.123", "/", "3.123")),
                Arguments.arguments("10.123456 + 20.123456 + 30.123456", List.of("10.123456", "+", "20.123456", "+", "30.123456")),
                Arguments.arguments("10.123456 - 20.123456 - 30.123456", List.of("10.123456", "-", "20.123456", "-", "30.123456")),
                Arguments.arguments("10.123456 * 20.123456 * 30.123456", List.of("10.123456", "*", "20.123456", "*", "30.123456")),
                Arguments.arguments("10.123456 / 20.123456 / 30.123456", List.of("10.123456", "/", "20.123456", "/", "30.123456")),
                Arguments.arguments("10.123456 + 20.123456 + 30.123456", List.of("10.123456", "+", "20.123456", "+", "30.123456")),
                Arguments.arguments("10.123456 + 20.123456 - 30.123456", List.of("10.123456", "+", "20.123456", "-", "30.123456")),
                Arguments.arguments("10.123456 + 20.123456 * 30.123456", List.of("10.123456", "+", "20.123456", "*", "30.123456")),
                Arguments.arguments("10.123456 + 20.123456 / 30.123456", List.of("10.123456", "+", "20.123456", "/", "30.123456")),
                Arguments.arguments(
                        "100.0000123456789 + 200.0000123456789 + 300.0000123456789",
                        List.of("100.0000123456789", "+", "200.0000123456789", "+", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 - 200.0000123456789 - 300.0000123456789",
                        List.of("100.0000123456789", "-", "200.0000123456789", "-", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 * 200.0000123456789 * 300.0000123456789",
                        List.of("100.0000123456789", "*", "200.0000123456789", "*", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 / 200.0000123456789 / 300.0000123456789",
                        List.of("100.0000123456789", "/", "200.0000123456789", "/", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 + 200.0000123456789 + 300.0000123456789",
                        List.of("100.0000123456789", "+", "200.0000123456789", "+", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 + 200.0000123456789 - 300.0000123456789",
                        List.of("100.0000123456789", "+", "200.0000123456789", "-", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 + 200.0000123456789 * 300.0000123456789",
                        List.of("100.0000123456789", "+", "200.0000123456789", "*", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 + 200.0000123456789 / 300.0000123456789",
                        List.of("100.0000123456789", "+", "200.0000123456789", "/", "300.0000123456789"
                        ))
        );
    }

    static Stream<Arguments> whenIntegerAndDoubleFormulaThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("1.1", List.of("1.1")),
                Arguments.arguments("1.1 + 1.1", List.of("1.1", "+", "1.1")),
                Arguments.arguments("1.1 - 1.1", List.of("1.1", "-", "1.1")),
                Arguments.arguments("1.1 * 1.1", List.of("1.1", "*", "1.1")),
                Arguments.arguments("1.1 / 1.1", List.of("1.1", "/", "1.1")),
                Arguments.arguments("1 + 2.123 + 3.123", List.of("1", "+", "2.123", "+", "3.123")),
                Arguments.arguments("1 - 2.123 - 3.123", List.of("1", "-", "2.123", "-", "3.123")),
                Arguments.arguments("1 * 2.123 * 3.123", List.of("1", "*", "2.123", "*", "3.123")),
                Arguments.arguments("1 / 2.123 / 3.123", List.of("1", "/", "2.123", "/", "3.123")),
                Arguments.arguments("1 + 2.123 + 3.123", List.of("1", "+", "2.123", "+", "3.123")),
                Arguments.arguments("1 + 2.123 - 3.123", List.of("1", "+", "2.123", "-", "3.123")),
                Arguments.arguments("1 + 2.123 * 3.123", List.of("1", "+", "2.123", "*", "3.123")),
                Arguments.arguments("1 + 2.123 / 3.123", List.of("1", "+", "2.123", "/", "3.123")),
                Arguments.arguments("10 + 20.123456 + 30", List.of("10", "+", "20.123456", "+", "30")),
                Arguments.arguments("10 - 20.123456 - 30", List.of("10", "-", "20.123456", "-", "30")),
                Arguments.arguments("10 * 20.123456 * 30", List.of("10", "*", "20.123456", "*", "30")),
                Arguments.arguments("10 / 20.123456 / 30", List.of("10", "/", "20.123456", "/", "30")),
                Arguments.arguments("10 + 20.123456 + 30", List.of("10", "+", "20.123456", "+", "30")),
                Arguments.arguments("10 + 20.123456 - 30", List.of("10", "+", "20.123456", "-", "30")),
                Arguments.arguments("10 + 20.123456 * 30", List.of("10", "+", "20.123456", "*", "30")),
                Arguments.arguments("10 + 20.123456 / 30", List.of("10", "+", "20.123456", "/", "30")),
                Arguments.arguments(
                        "100.0000123456789 + 200 + 300.0000123456789",
                        List.of("100.0000123456789", "+", "200", "+", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 - 200 - 300.0000123456789",
                        List.of("100.0000123456789", "-", "200", "-", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 * 200 * 300.0000123456789",
                        List.of("100.0000123456789", "*", "200", "*", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 / 200 / 300.0000123456789",
                        List.of("100.0000123456789", "/", "200", "/", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 + 200 + 300.0000123456789",
                        List.of("100.0000123456789", "+", "200", "+", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 + 200 - 300.0000123456789",
                        List.of("100.0000123456789", "+", "200", "-", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 + 200 * 300.0000123456789",
                        List.of("100.0000123456789", "+", "200", "*", "300.0000123456789")
                ),
                Arguments.arguments(
                        "100.0000123456789 + 200 / 300.0000123456789",
                        List.of("100.0000123456789", "+", "200", "/", "300.0000123456789")
                )
        );
    }

    static Stream<Arguments> whenUnreadableFormulaThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments("+"),
                Arguments.arguments("-"),
                Arguments.arguments("*"),
                Arguments.arguments("/"),
                Arguments.arguments("1 +"),
                Arguments.arguments("1 -"),
                Arguments.arguments("1 *"),
                Arguments.arguments("1 /"),
                Arguments.arguments("12 +"),
                Arguments.arguments("12 -"),
                Arguments.arguments("12 *"),
                Arguments.arguments("12 /"),
                Arguments.arguments("123 +"),
                Arguments.arguments("123 -"),
                Arguments.arguments("123 *"),
                Arguments.arguments("123 /"),
                Arguments.arguments("1 + 1 +"),
                Arguments.arguments("1 + 1 -"),
                Arguments.arguments("1 + 1 *"),
                Arguments.arguments("1 + 1 /"),
                Arguments.arguments("1 + 12 - 123 * 1234 /"),
                Arguments.arguments("1 - 12 + 123 * 1234 /"),
                Arguments.arguments("1 + 12 - 123 / 1234 *"),
                Arguments.arguments("1 * 12 + 123 - 1234 /")
        );
    }

    static Stream<Arguments> whenWrongFormulaThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments("1 ! 1"),
                Arguments.arguments("1 @ 1"),
                Arguments.arguments("1 # 1"),
                Arguments.arguments("1 $ 1"),
                Arguments.arguments("1 % 1"),
                Arguments.arguments("1 ^ 1"),
                Arguments.arguments("1 & 1"),
                Arguments.arguments("1 _ 1"),
                Arguments.arguments("1 = 1"),
                Arguments.arguments("1 \\ 1"),
                Arguments.arguments("1 | 1"),
                Arguments.arguments("1 ~ 1"),
                Arguments.arguments("1 ` 1"),
                Arguments.arguments("1 < 1"),
                Arguments.arguments("1 > 1"),
                Arguments.arguments("1 ? 1"),
                Arguments.arguments("1 : 1"),
                Arguments.arguments("1 ; 1"),
                Arguments.arguments("1 \" 1"),
                Arguments.arguments("1 { 1"),
                Arguments.arguments("1 } 1"),
                Arguments.arguments("1 [ 1"),
                Arguments.arguments("1 ] 1")
        );
    }
}
