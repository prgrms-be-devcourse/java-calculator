package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CalculatorTest {

    Calculator calculator;

    private static Stream<Arguments> provideExpression() { // argument source method
        return Stream.of(
            Arguments.of("1 + 3 / 2", Arrays.asList("1", "3", "2", "/", "+")),
            Arguments.of("1 / 5 / 3", Arrays.asList("1", "5", "/", "3", "/")),
            Arguments.of("1 * 3 + 5 / 2", Arrays.asList("1", "3", "*", "5", "2", "/", "+"))
        );
    }

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName("연산자를 주면 사칙연산을 실시한다.")
    @ParameterizedTest
    @CsvSource(value = {"+,1,2,3", "-,5,1,4", "*,5,2,10", "/,6,2,3"})
    void calcute_operator_returnResult(String operator, Double firstNumber, Double secondNumber, Double result) {
        assertThat(calculator.calculate(operator, firstNumber, secondNumber)).isEqualTo(result);
    }

    @DisplayName("/연산자일 때 0으로 나누면 예외를 던진다. ")
    @Test
    void calculate_divide_secondNumberIsZero_throwException() {
        assertThatThrownBy(() -> calculator.calculate("/", 3, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 0으로 나눌 수 없습니다. 다시 입력해주세요.");
    }

    @DisplayName("사칙연산자가 아니라면 예외를 던진다.")
    @ParameterizedTest
    @CsvSource(value = {",1,2", " ,5,1", "**,5,2", "//,6,2"})
    void calculate_notOperand_throwException(String operator, Double firstNumber, Double secondNumber) {
        assertThatThrownBy(() -> calculator.calculate(operator, firstNumber, secondNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 연산자가 아닙니다. 다시 입력해주세요.");
    }

    @DisplayName("입력받은 식을 후위표기식으로 변환한다.")
    @ParameterizedTest
    @MethodSource("provideExpression")
    void parse_postfix(String input, List<String> expected) {
        List<String> result = calculator.parsePostfix(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력된 값이 공백이거나 null이면 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void parse_blankOrNull_throwException(String input) {
        assertThatThrownBy(() -> calculator.parsePostfix(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 정상적인 입력이 아닙니다. 다시 입력해주세요.");
    }
}
