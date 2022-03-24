package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CommandFilterImplTest {

    CommandFilter commandFilter = new CommandFilterImpl();

    @ParameterizedTest
    @CsvSource({ // given
            "1 + 2, 1 + 2",
            "-1 + 20, -1 + 20",
            "      -1     +    20, -1 + 20",
            "1 + 2 + 3 * 6 /          10, 1 + 2 + 3 * 6 / 10",
            "  2147483647 - 2 1 4 7483648, 2147483647 - 2147483648"

    })
    public void 필터_성공_테스트(String command, String expected) {
        // when
        String actual = commandFilter.filter(command);
        System.out.printf("command : [%s], expected: [%s], actual : [%s]\n", command, expected, actual);
        // then
        Assertions.assertEquals(expected, actual);
    }
}
