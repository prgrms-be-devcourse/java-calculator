package programmers.java.calulator.common.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackCalculatorTest {

    private Calculator stackCalculator = new StackCalculator();
    @ParameterizedTest
    @DisplayName("연산자 순서에 맞게 알맞은 계산 결과를 반환하는지 확인하는 테스트")
    @CsvSource({
            //given
            "2 + 3 * 4, 14",
            "10 / 2 - 1, 4",
            "2 * 3 * 4 / 2, 12",
            "10 + 20 - 30, 0"
    })
    public void 계산_결과_테스트(String expression, int expected) {
        // when
        int result = stackCalculator.calculate(expression);

        // then
        assertEquals(expected, result);
    }
}

