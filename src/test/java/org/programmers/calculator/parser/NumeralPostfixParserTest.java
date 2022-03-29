package org.programmers.calculator.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;

import java.util.ArrayList;
import java.util.List;

@DisplayName("정수 후위 표기법 변환")
public class NumeralPostfixParserTest {

    @Test
    @DisplayName("간단한 덧셈 변환")
    void parseShortPlus() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("1 + 2").toArray();

        Object[] expected = {"1", "2", "+"};

        // List<>끼리 assert 비교할 경우 순서를 무시하고 equals()가 true 일 수 있기 때문에 배열 비교로 한다.
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("간단한 뺄셈 변환")
    void parseShortMinus() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("1 - 2").toArray();

        Object[] expected = {"1", "2", "-"};

        // List<>끼리 assert 비교할 경우 순서를 무시하고 equals()가 true 일 수 있기 때문에 배열 비교로 한다.
        Assertions.assertArrayEquals(expected, result);
    }


    @Test
    @DisplayName("간단한 곱셈 변환")
    void parseShortMultiply() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("4 * 3").toArray();

        Object[] expected = {"4", "3", "*"};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("간단한 나눗셈 변환")
    void parseShortDivision() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("9 / 7").toArray();

        Object[] expected = {"9", "7", "/"};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("덧셈과 곱셈 복합 변환")
    void parsePlusWithMultiply() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("1 + 2 * 3").toArray();

        List<String> expectedList = new ArrayList<>();
        Object[] expected = {"1", "2", "3", "*", "+"};

        // List<>끼리 assert 비교할 경우 순서를 무시하고 equals()가 true 일 수 있기 때문에 배열 비교로 한다.
        Assertions.assertArrayEquals(expected, result);
    }
}