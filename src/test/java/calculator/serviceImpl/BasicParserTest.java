package calculator.serviceImpl;

import calculator.service.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BasicParserTest {

    private Parser parser = new BasicParser();

    /**
     * Validation Check
     */
    @ParameterizedTest
    @CsvSource({ // given
            "10 + 2 -", "*1 + 2 * 3", "3 - z200 * 29", "111 222", "100",
            "-100", "0", "100 ++ 200", "--100 + 200"
    })
    public void 올바르지않은_수식_검사(String command) {
        // when
        String actual = parser.parse(command);
        // then
        Assertions.assertEquals(null, actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            ".01 + 2.0.",
            "1.0 / 2..0",
            "-.1222.333 - 333",
            "1.1 + 1.20.33",
    })
    public void 올바르지않은_수식_검사_실수(String command) {
        // when
        String actual = parser.parse(command);
        // then
        Assertions.assertEquals(null, actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "*1 +     2",
            "        1 + 2          ** 3",
            "3 -         2 *    2  ㅋ",
            "300-    200-"
    })
    public void 공백이포함된_올바르지않은_수식_검사(String command) {
        // when
        String actual = parser.parse(command);
        // then
        Assertions.assertEquals(null, actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "1 + 2", "1 + 2 * 3", "3 - 2 * 2", "-3 + 2 * 2 / 2 - 1",
    })
    public void 올바른_수식_검사(String command) {
        // when
        String actual = parser.parse(command);
        // then
        Assertions.assertNotNull(actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "1.0 + 2.00",
            "12.44 + 15.88",
            "-1222.333 - 333",
            "11 + 12.330",
            "1.1-1 + 1.20"
    })
    public void 올바른_수식_검사_실수(String command) {
        String actual = parser.parse(command);
        // then
        Assertions.assertNotNull(actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "1 +     2",
            "        1 + 2          * 3",
            "3 -         2 *    2",
            "300-    200"
    })
    public void 공백이포함된_올바른_수식_검사(String command) {
        String actual = parser.parse(command);
        // then
        Assertions.assertNotNull(actual);
    }

    /**
     *  filter check
     */

    @ParameterizedTest
    @CsvSource({ // given
            " 1  +      2    , 1 + 2",
            "      -1     +    20, -1 + 20",
            "1 + 2 + 3 * 6 /          10, 1 + 2 + 3 * 6 / 10",
            "  2147483647 - 2 1 4 7483648, 2147483647 - 2147483648",
            "1+1-2+3*6/7, 1 + 1 - 2 + 3 * 6 / 7"

    })
    public void 필터_성공_테스트(String command, String expected) {
        // when
        String actual = parser.parse(command);
        System.out.printf("command : [%s], expected: [%s], actual : [%s]\n", command, expected, actual);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "1 . 0 + 2      . 0, 1.0 + 2.0",
            "1.        0 + 2.0, 1.0 + 2.0",
            "111.        222 + 300, 111.222 + 300",
            "1.0+1.11-2.111+11.3*6.0/7.33, 1.0 + 1.11 - 2.111 + 11.3 * 6.0 / 7.33"
    })
    public void 필터_성공_테스트_실수(String command, String expected) {
        // when
        String actual = parser.parse(command);
        System.out.printf("command : [%s], expected: [%s], actual : [%s]\n", command, expected, actual);
        // then
        Assertions.assertEquals(expected, actual);
    }

}