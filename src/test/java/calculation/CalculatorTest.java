package calculation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("연산자 우선순위 테스트")
    void priorityTest() {
        String infixExpr = "1 + 3 * 6";
        Calculator calculator = new Calculator(infixExpr);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(19);
    }

    @Test
    @DisplayName("괄호를 반영한 계산 테스트")
    void bracketsTest() {
        String infixExpr = "3 + (4 * 7)) - (6 / 3)";
        Calculator calculator = new Calculator(infixExpr);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(29);
    }

}