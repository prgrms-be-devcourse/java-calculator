package example.calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {

    @ParameterizedTest
    @MethodSource("testData")
    public void testCalculate(double operand1, double operand2, String operator, double expected) {
        Calculator calculator = new Calculator();
        double result = calculator.calculate(operand1, operand2, operator);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 2, "+", 3),
                Arguments.of(1, 2, "-", -1),
                Arguments.of(2, 3, "*", 6),
                Arguments.of(4, 2, "/", 2)
        );
    }
}