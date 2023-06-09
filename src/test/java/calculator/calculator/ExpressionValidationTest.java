package calculator.calculator;

import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionValidationTest {
    @Test
    @DisplayName("올바른 연산 식을 입력한 경우")
    void validExpression(){
        Assertions.assertThat(Calculator.validateExpression("3 + 5 * 2 - 1"))
                .isEqualTo(true);
    }
    @Test
    @DisplayName("올바른 연산자를 입력하지 않은 경우")
    void invalidOperator(){
        Assertions.assertThat(Calculator.validateExpression("3 _ 5 * 2"))
                .isEqualTo(false);
    }

    @Test
    @DisplayName("올바른 연산 식을 입력하지 않은 경우")
    void invalidExpression(){
        Assertions.assertThat(Calculator.validateExpression("- 5 / 5 + 1"))
                .isEqualTo(false);
    }

    @Test
    @DisplayName("분모가 0 또는 음수인 경우 에러 처리")
    void invalidArithmeticOperation(){
        Assertions.assertThat(Calculator.validateExpression("3 + 5 / -1"))
                .isEqualTo(false);
    }
}
