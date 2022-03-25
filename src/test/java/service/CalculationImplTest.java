package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculationImplTest {

    private Sorter sorter = new BasicSorter();
    private Calculate calculation = new CalculateImpl(sorter);

    @ParameterizedTest
    @CsvSource({ // given
            "1 + 2, 3",
            "1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1, 10",
            "1 + 2 + 3 + 4 + 5, 15"
    })
    public void 계산_덧셈_테스트(String command, double expected) {
        // when
        double actual = calculation.calc(command);
        System.out.printf("command : [%s], expected: [%s], actual : [%f]\n", command, expected, actual);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "0 - 1 - 1 - 1 - 1 - 1, -5",
            "10 - 11, -1",
            "-1 - 5, -6"
    })
    public void 계산_뺄셈_테스트(String command, double expected) {
        // when
        double actual = calculation.calc(command);
        System.out.printf("command : [%s], expected: [%s], actual : [%f]\n", command, expected, actual);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "2 * 2 * -1, -4",
            "2 * 2 * 1, 4",
            "-2 * 2 * 1, -4",
            "2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2, 1024"
    })
    public void 계산_곱셈_테스트(String command, double expected) {
        // when
        double actual = calculation.calc(command);
        System.out.printf("command : [%s], expected: [%s], actual : [%f]\n", command, expected, actual);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "20 / 2 / 2, 5",
            "20 / 2 / 2 / 2, 2.5",
            "20 / 2 / 2 / 2 / 2, 1.25",
            "20 / 2 / 2 / 2 / 2 / 2, 0.625",
    })
    public void 계산_나눗셈_테스트(String command, double expected) {
        // when
        double actual = calculation.calc(command);
        System.out.printf("command : [%s], expected: [%s], actual : [%f]\n", command, expected, actual);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "20 / 0",
            "2 * 3 * 1 / 0",
    })
    public void 계산_나눗셈_0으로나누는_경우_테스트(String command) {
        // when
        System.out.printf("command : [%s]\n", command);
        Assertions.assertThrows(RuntimeException.class, () -> calculation.calc(command));
    }

    @ParameterizedTest
    @CsvSource({ // given
           "1 + 2 * 3 / 4 + 1, 3.5",
            "1 / 2 * 3 - 1 - 0 / 2, 0.5",
            "1 * 0 + 1 - 1 / 10, 0.9"
    })
    public void 계산_혼합_테스트(String command, double expected) {
        // when
        double actual = calculation.calc(command);
        System.out.printf("command : [%s], expected: [%s], actual : [%f]\n", command, expected, actual);
        // then
        Assertions.assertEquals(expected, actual);
    }
}

