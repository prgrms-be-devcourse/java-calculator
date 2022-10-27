package com.programmers.cal;

import com.programmers.cal.engine.parse.ExpressionParser;
import com.programmers.cal.engine.parse.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    Parser parser = new ExpressionParser();

    @Test
    @DisplayName("파싱 성공")
    public void successParsing() {
        //given
        String inputString1 = "12+34+45";
        String inputString2 = "1 2+ -34* 2";
        String inputString3 = "-12+-34+-45";

        List<String> expected1 = Arrays.asList("12", "+", "34", "+", "45");
        List<String> expected2 = Arrays.asList("12", "+", "-34", "*", "2");
        List<String> expected3 = Arrays.asList("-12", "+", "-34", "+", "-45");

        //then
        assertThat(parser.getTokenList((inputString1))).isEqualTo(expected1);
        assertThat(parser.getTokenList((inputString2))).isEqualTo(expected2);
        assertThat(parser.getTokenList((inputString3))).isEqualTo(expected3);
    }
}
