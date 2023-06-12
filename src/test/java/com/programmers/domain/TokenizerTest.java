package com.programmers.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest {
    private Tokenizer tokenizer = new Tokenizer();

    @Test
    void inputData() {
        //given
        String inputA = "   1   +    2 +   3";
        String inputB = "1+2+3";

        //when
        List<String> tokenizedA = tokenizer.tokenize(inputA);
        List<String> tokenizedB = tokenizer.tokenize(inputB);

        //then
        assertThat(tokenizedA).containsExactly("1", "+", "2", "+", "3");
        assertThat(tokenizedB).containsExactly("1", "+", "2", "+", "3");
    }
}
