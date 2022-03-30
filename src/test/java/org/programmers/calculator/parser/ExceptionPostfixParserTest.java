package org.programmers.calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.postfixParser.NumeralPostfixParser;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("변환 중 예외 처리")
public class ExceptionPostfixParserTest {

    @Test
    @DisplayName("예외: 소수점이 앞에 수 없이 찍혔을 때")
    void parseWithDotFailed() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse(".41 + 3"));
    }

    @Test
    @DisplayName("예외: 연산자가 연이어 들어올 때")
    void chainOfOperator() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse("1 + + 2"));
    }

    @Test
    @DisplayName("예외: 연산자가 첫 자리에 들어올 때")
    void operatorInFirstPlace() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse(" + 1 + 2"));
    }

    @Test
    @DisplayName("예외: 소수점이 여럿 찍혔을 때")
    void parseShortPlusFailed() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse("4.. 1 + 3.."));
    }

    @Test
    @DisplayName("예외: 알파벳이 들어왔을 때")
    void parseWithAlphabetFailed() {
        NumeralPostfixParser parser = new NumeralPostfixParser(new NumeralTypeChecker());
        assertThrows(IllegalArgumentException.class,
                () -> parser.parse("a5 + 1"));
    }
}
