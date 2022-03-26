package com.waterfogsw.parser;

import com.waterfogsw.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ParserTest {
    private Parser parser;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        parser = appConfig.parser();
    }

    @Test
    public void 문자열_파싱_테스트1() throws Exception {
        // given
        String exprStr = "2 + 2 + 2";

        // when
        List<String> exprList = parser.parse(exprStr);

        // then
        Assertions.assertThat(exprList).isEqualTo(Arrays.asList("2", "+", "2", "+", "2"));
    }

    @Test
    public void 문자열_파싱_테스트2() throws Exception {
        // given
        String exprStr = "(4 - 2) * 2";

        // when
        List<String> exprList = parser.parse(exprStr);

        // then
        Assertions.assertThat(exprList).isEqualTo(Arrays.asList("(", "4", "-", "2", ")", "*", "2"));
    }
}