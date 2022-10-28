package com.programmers.cal;

import com.programmers.cal.engine.model.InputData;
import com.programmers.cal.engine.parse.ExpressionParser;
import com.programmers.cal.engine.parse.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    Parser parser = new ExpressionParser();
    InputData inputData = new InputData();

    @Test
    @DisplayName("파싱 성공")
    public void successParsing() {
        //given
        InputData inputData1 = inputData.toInputData("12+34+45");
        InputData inputData2 = inputData.toInputData("1 2+ -34* 2");
        InputData inputData3 = inputData.toInputData("-12+-34+-45");

        List<String> expected1 = Arrays.asList("12", "+", "34", "+", "45");
        List<String> expected2 = Arrays.asList("12", "+", "-34", "*", "2");
        List<String> expected3 = Arrays.asList("-12", "+", "-34", "+", "-45");

        //then
        assertThat(parser.getTokenList(inputData1)).isEqualTo(expected1);
        assertThat(parser.getTokenList(inputData2)).isEqualTo(expected2);
        assertThat(parser.getTokenList(inputData3)).isEqualTo(expected3);
    }
}
