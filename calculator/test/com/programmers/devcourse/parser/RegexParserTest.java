package com.programmers.devcourse.parser;

import com.programmers.devcourse.exception.parser.NotAcceptableStringException;
import com.programmers.devcourse.exception.parser.ParserException;
import com.programmers.devcourse.exception.parser.WrongTokenCountException;
import com.programmers.devcourse.exception.parser.WrongTokenPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentest4j.AssertionFailedError;

class RegexParserTest {

  Parser parser = new RegexParser();
  Object[] parsedTokenArray;
  String[] compareTarget;


  @DisplayName("문자열에 빈 칸이 없을 때 토큰을 정확하게 구해야 한다.")
  @Test
  void testParserShouldReturnProperTokenArrayWhenTargetStringHasNoSpace() throws ParserException {
    Parser parser = new RegexParser();
    // test 공백 없이 붙여 넣었을 때
    parsedTokenArray = parser.parse("1+2*3+4.54234").toArray();
    compareTarget =
        new String[]{"1", "+", "2", "*", "3", "+", "4.54234"};
    Assertions.assertArrayEquals(parsedTokenArray, compareTarget);

    // 실패해야 할 테스트(연산자 차이)
    compareTarget = new String[]{"1", "-", "2", "*", "3", "+", "4.54234"};

    Assertions.assertThrows(AssertionFailedError.class, () -> {
      Assertions.assertArrayEquals(parsedTokenArray, compareTarget);

    });


  }

  @DisplayName("문자열에 빈칸 있을 때 정확하게 토큰을 구해야 한다.")
  @Test
  void testParserShouldReturnProperTokenArrayWhenInputStringHasSpace() throws ParserException {

    // 공백이 존재할 때
    parsedTokenArray = parser.parse("5.3 + 4 /6").toArray();
    compareTarget = new String[]{"5.3", "+", "4", "/", "6"};
    Assertions.assertArrayEquals(parsedTokenArray, compareTarget);

    // 실패해야 할 테스트(연산자 차이)
    compareTarget = new String[]{"5.3", "-", "4", "/", "6"};
    try {
      Assertions.assertArrayEquals(parsedTokenArray, compareTarget);
    } catch (AssertionFailedError e) {
      System.out.println(e.getMessage());
    }


  }

  @DisplayName("토큰 개수가 연산에 적합하지 않을 때 WrongTokenCountException을 던져야 한다.")
  @ParameterizedTest()
  @ValueSource(strings = {"1+2*", "           "})
  void testParserThrowsExceptionWhenInputStringHasWrongTokenCount(String target) {
    Assertions.assertThrows(WrongTokenCountException.class, () -> {
      parser.parse(target);
    }).getMessage();

  }


  @DisplayName("토큰들의 순서가 연산에 적합하지 않을 때 WrongTokenPositionException을 던져야 한다.")
  @ParameterizedTest()
  @ValueSource(strings = {"+45", "5  3 +"})
  void testParserThrowExceptionWhenInputStringHasWrongOrder(String target) {
    Assertions.assertThrows(WrongTokenPositionException.class, () -> {
      parser.parse(target);
    });
  }

  @DisplayName("토큰에 적합하지 않은 문자열이 들어왔을 때 NotAccpetableStringException을 던져야 한다.")
  @ParameterizedTest
  @ValueSource(strings = {"        a ", "  asdfkjzxv ", "@#IY@Y&*&Y&*"})
  void testParserThrowNotAcceptableStringExceptionWhenInputStringHasWrongCharacter(String target) {
    Assertions.assertThrows(NotAcceptableStringException.class, () -> {
      parser.parse(target);
    });
  }


}