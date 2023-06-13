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
    void validateExpression(String expression, boolean isValid) {
        boolean isValidResult = CalculatorValidator.isValidExpression(expression);
        assertEquals(isValid, isValidResult);
    }

    private static Stream<Arguments> testValidExpression(){
        return Stream.of(
                Arguments.of("3 + 6 / -2", true),
                Arguments.of("3 * 1 - 2", true),
                Arguments.of("-2 * -1 + 3", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testInvalidExpression")
    @DisplayName("올바르지 않은 수식 표현을 검증하는 테스트")
    void validateInvalidExpression(String expression, boolean isValid) {
        boolean isValidResult = CalculatorValidator.isValidExpression(expression);
        assertEquals(isValid, isValidResult);
    }

    private static Stream<Arguments> testInvalidExpression() {
        return Stream.of(
                Arguments.of("3 + ", false),
                Arguments.of("3", false),
                Arguments.of("+", false),
                Arguments.of("-3", false)
        );
    }
}