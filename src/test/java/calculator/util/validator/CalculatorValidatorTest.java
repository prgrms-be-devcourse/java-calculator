package calculator.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorValidatorTest {

    @ParameterizedTest
    @MethodSource("testValidExpression")
    @DisplayName("올바른 수식 표현을 검증하는 테스트")
    void validateExpression(String expression) {
        boolean isValidResult = CalculatorValidator.isValidExpression(expression);
        assertTrue(isValidResult);
    }

    private static Stream<Arguments> testValidExpression(){
        return Stream.of(
                Arguments.of("3 + 6 / -2"),
                Arguments.of("3 * 1 - 2"),
                Arguments.of("-2 * -1 + 3")
        );
    }

    @ParameterizedTest
    @MethodSource("testInvalidExpression")
    @DisplayName("올바르지 않은 수식 표현을 검증하는 테스트")
    void validateInvalidExpression(String expression) {
        boolean isValidResult = CalculatorValidator.isValidExpression(expression);
        assertFalse(isValidResult);
    }

    private static Stream<Arguments> testInvalidExpression() {
        return Stream.of(
                Arguments.of("3 + "),
                Arguments.of("3"),
                Arguments.of("+"),
                Arguments.of("-3"),
                Arguments.of("-3 + + "),
                Arguments.of("-3 + 5 5 6"),
                Arguments.of("+ 1 - 5")
        );
    }
}