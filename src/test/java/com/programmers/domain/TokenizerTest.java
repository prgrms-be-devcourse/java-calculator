package com.programmers.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest {
    @ParameterizedTest
    @CsvSource(value = {
            "   1   +    2 +   3:1 + 2 + 3",
            "1+2+3:1 + 2 + 3"
    }, delimiter = ':')
    void inputData(String input, String result) {
        //given

        //when
        List<String> tokenized = Tokenizer.tokenizeAsExpression(input);

        //then
        List<String> expected = Arrays.stream(result.split(" ")).toList();

        assertThat(tokenized).containsExactlyElementsOf(expected);
    }
}
