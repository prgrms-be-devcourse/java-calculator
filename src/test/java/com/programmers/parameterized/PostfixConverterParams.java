package com.programmers.parameterized;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class PostfixConverterParams {
    public static Stream<Arguments> parsingDataMixedWithPlusAndMinus() {
        return Stream.of(
                Arguments.of(
                        List.of("1", "+", "3", "-", "4"),
                        List.of("1", "3", "+", "4", "-")
                )
        );
    }

    public static Stream<Arguments> parsingDataMixedAllOperator() {
        return Stream.of(
                Arguments.of(
                        List.of("1", "*", "1", "+", "1", "/", "1"),
                        List.of("1", "1", "*", "1", "1", "/", "+")
                ),
                Arguments.of(
                        List.of("1", "-", "1", "*", "1", "/", "1"),
                        List.of("1", "1", "1", "*", "1", "/", "-")
                )
        );
    }
}
