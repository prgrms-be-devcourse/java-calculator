package calculator.calculator;

import calculator.calculator.formula.FormulaBasicParser;
import calculator.calculator.notation.calculation.NotationPostfixCalculation;
import calculator.calculator.notation.parser.NotationPostfixParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixCalculatorTest {

    private final Calculator calculator =
            new Calculator(
                    new NotationPostfixCalculation(),
                    new NotationPostfixParser(),
                    new FormulaBasicParser()
            );

    @ParameterizedTest(name = "[{index}] formula = {0}, expect = {1}")
    @MethodSource("whenCalculateIntegerWithPostfixCalculatorThenSuccessDummy")
    @DisplayName("정수형 연산식, 후위 표기식 연산 성공 테스트")
    void whenCalculateIntegerWithPostfixCalculatorThenSuccessTest(String formula, String expect) {
        BigDecimal result = calculator.calculate(formula).getCalculationResult();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = {0}, expect = {1}")
    @MethodSource("whenCalculateDoubleWithPostfixCalculatorThenSuccessDummy")
    @DisplayName("실수형 연산식, 후위 표기식 연산 성공 테스트")
    void whenCalculateDoubleWithPostfixCalculatorThenSuccessTest(String formula, String expect) {
        BigDecimal result = calculator.calculate(formula).getCalculationResult();
        assertThat(result).isEqualTo(expect);
    }

    static Stream<Arguments> whenCalculateIntegerWithPostfixCalculatorThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("1 + 2", "3"),
                Arguments.arguments("1 - 2", "-1"),
                Arguments.arguments("1 * 2", "2"),
                Arguments.arguments("1 / 2", "0.500000000000000"),
                Arguments.arguments("1 + 2 + 3", "6"),
                Arguments.arguments("1 + 2 - 3", "0"),
                Arguments.arguments("1 + 2 * 3", "7"),
                Arguments.arguments("1 + 2 / 3", "1.666666666666667"),
                Arguments.arguments("1 + 2 / 3 + 9", "10.666666666666667"),

                Arguments.arguments("10 + 20", "30"),
                Arguments.arguments("10 - 20", "-10"),
                Arguments.arguments("10 * 20", "200"),
                Arguments.arguments("10 / 20", "0.500000000000000"),
                Arguments.arguments("10 + 20 + 30", "60"),
                Arguments.arguments("10 + 20 - 30", "0"),
                Arguments.arguments("10 + 20 * 30", "610"),
                Arguments.arguments("10 + 20 / 30", "10.666666666666667"),
                Arguments.arguments("10 + 2 / 3", "10.666666666666667")
        );
    }

    static Stream<Arguments> whenCalculateDoubleWithPostfixCalculatorThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("1.1 + 2.2", "3.3"),
                Arguments.arguments("1.1 - 2.2", "-1.1"),
                Arguments.arguments("1.1 * 2.2", "2.42"),
                Arguments.arguments("1.1 / 2.2", "0.500000000000000"),
                Arguments.arguments("1.1 + 2.2 + 3", "6.3"),
                Arguments.arguments("1.1 + 2.2 - 3", "0.3"),
                Arguments.arguments("1.1 + 2.2 * 3", "7.7"),
                Arguments.arguments("1.1 + 2.2 / 3", "1.833333333333333"),
                Arguments.arguments("1.1 + 2.2 / 3 + 9", "10.833333333333333"),

                Arguments.arguments("10.1 + 20.2", "30.3"),
                Arguments.arguments("10.1 - 20.2", "-10.1"),
                Arguments.arguments("10.1 * 20.2", "204.02"),
                Arguments.arguments("10.1 / 20.2", "0.500000000000000"),
                Arguments.arguments("10.1 + 20.2 + 30.3", "60.6"),
                Arguments.arguments("10.1 + 20.2 - 30.3", "0.0"),
                Arguments.arguments("10.1 + 20.2 * 30.3", "622.16"),
                Arguments.arguments("10.1 + 20.2 / 30.3", "10.766666666666667"),
                Arguments.arguments("10.1 + 2.2/ 3.3", "10.766666666666667")
        );
    }

}