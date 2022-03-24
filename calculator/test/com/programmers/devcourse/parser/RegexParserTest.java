package com.programmers.devcourse.parser;

import com.programmers.devcourse.exception.parser.NotAcceptableStringException;
import com.programmers.devcourse.exception.parser.ParserException;
import com.programmers.devcourse.exception.parser.WrongTokenCountException;
import com.programmers.devcourse.exception.parser.WrongTokenPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

class RegexParserTest {

  static Parser parser;
  Object[] parsedTokenArray;
  String[] compareTarget;

  @BeforeAll
  public static void settingParser() {
    parser = new RegexParser();
  }

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

  @Test()
  void testParserThrowsExceptionWhenInputStringHasWrongTokenCount() {
    Assertions.assertThrows(WrongTokenCountException.class, () -> {
      parser.parse("1+2*");
      parser.parse("           ");
    });
  }


  @Test()
  void testParserThrowExceptionWhenInputStringHasWrongOrder() {
    Assertions.assertThrows(WrongTokenPositionException.class, () -> {
      parser.parse("+4+5");
    });
  }

  @Test()
  void testParserThrowNotAcceptableStringExceptionWhenInputStringHasWrongCharacter() {
    Assertions.assertThrows(NotAcceptableStringException.class, () -> {
      parser.parse("        a ");
    });
    Assertions.assertThrows(NotAcceptableStringException.class, () -> {
      parser.parse("  asdfkjzxv ");
    });
    Assertions.assertThrows(NotAcceptableStringException.class, () -> {
      parser.parse("abvracvsdf");
    });
  }


}