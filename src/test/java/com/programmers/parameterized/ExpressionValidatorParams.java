package com.programmers.parameterized;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class ExpressionValidatorParams {
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
}
