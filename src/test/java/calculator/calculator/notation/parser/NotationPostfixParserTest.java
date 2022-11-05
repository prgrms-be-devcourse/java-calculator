package calculator.calculator.notation.parser;

import calculator.calculator.formula.Formula;
import calculator.calculator.formula.FormulaBasicParser;
import calculator.calculator.formula.FormulaParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NotationPostfixParserTest {

    private final FormulaParser formulaParser = new FormulaBasicParser();
    private final NotationParser notationParser = new NotationPostfixParser();

    @ParameterizedTest(name = "[{index}] formula = {0}, expect = {1}")
    @MethodSource(value = "whenParseNotationThenSuccessDummy")
    @DisplayName("후위 표기법 파싱 성공 테스트")
    void whenParseNotationThenSuccessTest(String formula, String expect) {
        Formula parsedToFormula = formulaParser.parseFrom(formula);
        List<String> parsedToNotation = notationParser.parseFrom(parsedToFormula).getFormulaPieces();

        String result = parsedToNotation.toString();

        assertThat(result).isEqualTo(expect);
    }

    static Stream<Arguments> whenParseNotationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("1 + 2", "[1, 2, +]"),
                Arguments.arguments("1 - 2", "[1, 2, -]"),
                Arguments.arguments("1 * 2", "[1, 2, *]"),
                Arguments.arguments("1 / 2", "[1, 2, /]"),
                Arguments.arguments("1 + 2 + 3", "[1, 2, +, 3, +]"),
                Arguments.arguments("1 + 2 - 3", "[1, 2, +, 3, -]"),
                Arguments.arguments("1 + 2 * 3", "[1, 2, 3, *, +]"),
                Arguments.arguments("1 + 2 / 3", "[1, 2, 3, /, +]"),
                Arguments.arguments("1 - 2 + 3", "[1, 2, -, 3, +]"),
                Arguments.arguments("1 * 2 + 3", "[1, 2, *, 3, +]"),
                Arguments.arguments("1 / 2 + 3", "[1, 2, /, 3, +]"),
                Arguments.arguments("1 + 2 + 3 + 4", "[1, 2, +, 3, +, 4, +]"),
                Arguments.arguments("1 + 2 + 3 - 4", "[1, 2, +, 3, +, 4, -]"),
                Arguments.arguments("1 + 2 + 3 * 4", "[1, 2, +, 3, 4, *, +]"),
                Arguments.arguments("1 + 2 + 3 / 4", "[1, 2, +, 3, 4, /, +]"),
                Arguments.arguments("1 + 2 - 3 * 4", "[1, 2, +, 3, 4, *, -]"),
                Arguments.arguments("1 + 2 - 3 / 4", "[1, 2, +, 3, 4, /, -]"),
                Arguments.arguments("1 * 2 / 3 + 4", "[1, 2, *, 3, /, 4, +]"),
                Arguments.arguments("1 / 2 * 3 / 4", "[1, 2, /, 3, *, 4, /]"),
                Arguments.arguments(
                        "1 / 2 * 3 / 4 + 5 + 6 + 7 - 8 / 9 * 10 / 11 * 12 * 13 - 14 / 15 - 16 * 17",
                        "[1, 2, /, 3, *, 4, /, 5, +, 6, +, 7, +, 8, 9, /, -, 10, *, 11, /, 12, *, 13, *, 14, 15, /, -, 16, 17, *, -]"
                )
        );
    }

}