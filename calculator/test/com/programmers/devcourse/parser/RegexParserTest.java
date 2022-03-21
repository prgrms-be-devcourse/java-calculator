package com.programmers.devcourse.parser;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RegexParserTest {

  @Test
  void parserMustTokenizeTargetByNumberOrOperator() {
    Parser parser = new RegexParser();
    assert Arrays.deepEquals(parser.parse("1+2*3+4.54234").toArray(),
        new String[]{"1", "+", "2", "*", "3", "+", "4.54234"});

    assert Arrays.deepEquals(parser.parse("5.3 + 4 /6").toArray(),
        new String[]{"5.3", "+", "4", "/", "6"});

  }

}