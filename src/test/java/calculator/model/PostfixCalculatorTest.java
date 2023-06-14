package calculator.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PostfixCalculatorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void calculate(List<String> postfix, Integer expectedResult) {
        PostfixCalculator postfixCalculator = new PostfixCalculator();

        Integer result = postfixCalculator.calculate(postfix);

        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(Arrays.asList("3", "5", "+"), 8),
                Arguments.of(Arrays.asList("3", "5", "*", "-2", "-"), 13), // failed
                Arguments.of(Arrays.asList("3", "5", "+", "2", "1", "*", "-"), 6),
                Arguments.of(Arrays.asList("1", "5", "2", "*", "+"), 11),
                Arguments.of(Arrays.asList("3", "6", "2", "*", "3", "/", "+"), 7)
        );
    }
}