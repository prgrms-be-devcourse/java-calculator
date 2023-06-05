package programmers.java.calulator.common.engine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorEngineTest {

    @Test
    @DisplayName("연산자 순서에 맞게 알맞은 계산 결과를 반환하는지 확인하는 테스트")
    public void 계산_결과_테스트() {
        // given
        String expression1 = "2 + 3 * 4";
        String expression2 = "10 / 2 - 1";
        String expression3 = "2 * 3 * 4 / 2";
        String expression4 = "10 + 20 - 30";

        // when
        int result1 = new CalculatorEngine(expression1).evaluate();
        int result2 = new CalculatorEngine(expression2).evaluate();
        int result3 = new CalculatorEngine(expression3).evaluate();
        int result4 = new CalculatorEngine(expression4).evaluate();

        // then
        assertEquals(14, result1);
        assertEquals(4, result2);
        assertEquals(12, result3);
        assertEquals(0, result4);
    }
}

