package calculator.parse;

import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    Parser parser;

    @BeforeEach
    void beforeEach() {
        parser = new StackParser();
    }

    @DisplayName("정상적인 파싱 테스트")
    @Test
    void validStackParserTest() {
        String mock = "3+2*4-9/3";
        ArrayList<String> want = new ArrayList<>(Arrays.asList("3", "2", "4", "*", "+", "9", "3", "/", "-"));

        ArrayList<String> got = parser.parse(mock);

        Assertions.assertThat(got).isEqualTo(want);
    }

    @DisplayName("수식에 공백이 있더라도 제대로 파싱해주는지 테스트")
    @Test
    void validSpaceStackParserTest() {
        String mock = "3-            6 + 1 *    7";
        ArrayList<String> want = new ArrayList<>(Arrays.asList("3", "6", "-", "1", "7", "*", "+"));

        ArrayList<String> got = parser.parse(mock);

        Assertions.assertThat(got).isEqualTo(want);
    }

    @DisplayName("숫자가 2자리 이상일경우 제대로 구분되는지")
    @Test
    void validMoreThanTwoDigitStackParserTest() {
        String mock = "36+13-654*2/5";
        ArrayList<String> want = new ArrayList<>(Arrays.asList("36", "13", "+", "654", "2", "*", "5", "/", "-"));

        ArrayList<String> got = parser.parse(mock);

        Assertions.assertThat(got).isEqualTo(want);
    }

    @DisplayName("잘못된 연산자가 들어왔을 경우 예외 발생")
    @Test
    void wrongOperatorStackParserTest() {
        String mock = "3%6";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> parser.parse(mock));

        Assertions.assertThat(e.getMessage()).isEqualTo(StackParser.WRONG_ARGUMENTS);
    }

    @DisplayName("연산자 + 숫자(int) 이외의 값이 들어오는 경우 예외 발생")
    @Test
    void wrongUnknownValueStackParserTest() {
        String mock = "one+two";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> parser.parse(mock));

        Assertions.assertThat(e.getMessage()).isEqualTo(StackParser.WRONG_ARGUMENTS);
    }

    @DisplayName("잘못된 수식이 들어왔을 경우 테스트")
    @Test
    void wrongExpressCheck() {
        String[] mocks = {
                "3+",
                "+3",
                "-+*/",
                "3++3",
                "-33",
                "35-",
                "365-11-"
        };
        for (String mock : mocks) {
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> parser.parse(mock));

            Assertions.assertThat(e.getMessage()).isEqualTo(StackParser.OPERAND_NOT_MATCH);
        }
    }
}