package com.programmers.parameterized;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class CalculatorParams {
    //validate
    public static Stream<Arguments> validateInvalidOrder_Then_Exception() {
        return Stream.of(
                Arguments.of(List.of("1", "1", "1")),
                Arguments.of(List.of("+", "1", "/")),
                Arguments.of(List.of("1", "+", "+", "1"))
        );
    }

    public static Stream<Arguments> validateExpressionEndWithOperator_Then_Exception() {
        return Stream.of(
                Arguments.of(List.of("1", "+")),
                Arguments.of(List.of("1", "*", "1", "_"))
        );
    }

    public static Stream<Arguments> validateValidExpression() {
        return Stream.of(
                Arguments.of(List.of("1", "+", "1")),
                Arguments.of(List.of("1", "/", "1", "*", "1"))
        );
    }


    //calculate()
    public static Stream<Arguments> calculateOnlyPlus() {
        return Stream.of(
                Arguments.of(List.of("1", "+", "5"), 6),
                Arguments.of(List.of("123", "+", "234", "+", "2134"), 2491),
                Arguments.of(List.of("1", "+", "2", "+", "3", "+", "4"), 10)
        );
    }

    public static Stream<Arguments> calculateOnlyMinus() {
        return Stream.of(
                Arguments.of(List.of("1", "-", "5"), -4),
                Arguments.of(List.of("123", "-", "23", "-", "523"), -423)
        );
    }

    public static Stream<Arguments> calculateMixedWithPlusAndMinus() {
        return Stream.of(
                Arguments.of(List.of("1", "+", "5", "-", "123"), -117),
                Arguments.of(List.of("123", "-", "2345", "+", "2452"), 230)
        );
    }

    public static Stream<Arguments> calculateOnlyMultiply() {
        return Stream.of(
                Arguments.of(List.of("2", "*", "5"), 10),
                Arguments.of(List.of("123", "*", "123", "*", "948"), 14342292)
        );
    }

    public static Stream<Arguments> calculateMultiplyMixedWithPlusAndMinus() {
        return Stream.of(
                Arguments.of(List.of("123", "+", "324", "*", "3", "-", "2332"), -1237),
                Arguments.of(List.of("123", "*", "324", "-", "32", "*", "42"), 38508)
        );
    }

    public static Stream<Arguments> calculateOnlyDivide() {
        return Stream.of(
                Arguments.of(List.of("123", "/", "23"), 5),
                Arguments.of(List.of("34", "/", "42", "/", "35"), 0)
        );
    }

    public static Stream<Arguments> calculateMixedAllOperation() {
        return Stream.of(
                Arguments.of(List.of("23", "*", "7", "+", "32", "/", "8"), 165),
                Arguments.of(List.of("23", "+", "3", "*", "23", "/", "2", "-", "12", "*", "17"), -147)
        );
    }
}
