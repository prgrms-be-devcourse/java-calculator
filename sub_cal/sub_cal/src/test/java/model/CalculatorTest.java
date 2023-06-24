package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator = new Calculator();
    @ParameterizedTest
    @DisplayName("결과값 확인")
    @MethodSource("testData")
    void calculate(String expression,String expected) {
        String result = calculator.calculate(expression);
        assertEquals(expected,result);
    }

    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of("1 + 3","4"),
                Arguments.of("1 * 3 + 6","9"),
                Arguments.of("1 + 3 * 9 - 7 * 8 * 2 / 8","14"),
                Arguments.of("1 + 2 - 1 * 3 - 2","-2")
        );
    }

}
