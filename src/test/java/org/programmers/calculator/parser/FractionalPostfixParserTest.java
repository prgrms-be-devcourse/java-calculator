package org.programmers.calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("소수 변환")
public class FractionalPostfixParserTest {

    @Test
    @DisplayName("간단한 소수 덧셈 변환")
    void parseShortPlus() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("1.5 + 2.5").toArray();

        Object[] expected = {"1.5", "2.5", "+"};

        // List<>끼리 assert 비교할 경우 순서를 무시하고 equals()가 true 일 수 있기 때문에 배열 비교로 한다.
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("소수의 곱셈 및 덧셈 복합 변환")
    void parsePlusWithMultiply() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        Object[] result = parser.parse("1.4 + 0.2 * 3.8").toArray();

        List<String> expectedList = new ArrayList<>();
        Object[] expected = {"1.4", "0.2", "3.8", "*", "+"};

        // List<>끼리 assert 비교할 경우 순서를 무시하고 equals()가 true 일 수 있기 때문에 배열 비교로 한다.
        assertArrayEquals(expected, result);
    }
}