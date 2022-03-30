package org.programmers.calculator.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;

@DisplayName("부호 붙은 경우 변환")
public class SignedPostfixParserTest {

    @Test
    @DisplayName("음수 변환")
    void parseNegative() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("-1 + 2").toArray();

        Object[] expected = {"-1", "2", "+"};

        // List<>끼리 assert 비교할 경우 순서를 무시하고 equals()가 true 일 수 있기 때문에 배열 비교로 한다.
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("양수 부호 붙은 경우 변환")
    void parsePositive() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("+1 + 2").toArray();

        Object[] expected = {"+1", "2", "+"};

        // List<>끼리 assert 비교할 경우 순서를 무시하고 equals()가 true 일 수 있기 때문에 배열 비교로 한다.
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("음수 부호 붙은 소수 변환")
    void parseNegativeFractional() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("-4.2 * -0.1").toArray();

        Object[] expected = {"-4.2", "-0.1", "*"};
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    @DisplayName("양수 부호 붙은 소수 변환")
    void parsePositiveFractional() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("+4.2 * 0.1").toArray();

        Object[] expected = {"+4.2", "0.1", "*"};
        Assertions.assertArrayEquals(expected, result);
    }
}