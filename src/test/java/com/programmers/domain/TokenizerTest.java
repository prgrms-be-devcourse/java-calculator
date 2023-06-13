package com.programmers.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest {
    private Tokenizer tokenizer = new Tokenizer();

    private static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(
                        "   1   +    2 +   3",
                        List.of("1", "+", "2", "+", "3")
                ),
                Arguments.of(
                        "1+2+3",
                        List.of("1", "+", "2", "+", "3")
                )
        );
    }

    @ParameterizedTest
    @MethodSource
    void inputData(String input, List<String> result) {
        //when
        List<String> tokenized = tokenizer.tokenize(input);

        //then
        assertThat(tokenized).containsExactlyElementsOf(result);
    }
}
