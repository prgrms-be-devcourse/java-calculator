package com.waterfogsw.tokenizer;

import com.waterfogsw.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class TokenizerTest {
    private Tokenizer tokenizer;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        tokenizer = appConfig.tokenizer();
    }

    @Test
    public void 문자열_토큰화_테스트1() throws Exception {
        // given
        String exprStr = "2 + 2 + 2";

        // when
        List<String> exprList = tokenizer.tokenize(exprStr);

        // then
        Assertions.assertThat(exprList).isEqualTo(Arrays.asList("2", "+", "2", "+", "2"));
    }

    @Test
    public void 문자열_토큰화_테스트2() throws Exception {
        // given
        String exprStr = "(4 - 2) * 2";

        // when
        List<String> exprList = tokenizer.tokenize(exprStr);

        // then
        Assertions.assertThat(exprList).isEqualTo(Arrays.asList("(", "4", "-", "2", ")", "*", "2"));
    }

    @Test
    public void 문자열_토큰화_테스트3() throws Exception {
        // given
        String exprStr = "-100 + 300";

        // when
        List<String> exprList = tokenizer.tokenize(exprStr);

        // then
        Assertions.assertThat(exprList).isEqualTo(Arrays.asList("-", "100", "+", "300"));
    }
}