package java.calculator.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("계산기 엔진을 통해 받은 값이 계산기 클래스에서 잘 작동하는지 학인하는 테스트")
    public void whenRawExpressionIsGiven_thenCalculateReturnsCorrectResult() {
        // given
        Calculator calculator = new Calculator();
        String expression = "2 + 3 * 4";

        // when
        int result = calculator.calculate(expression);

        // then
        assertEquals(14, result);
    }
}
