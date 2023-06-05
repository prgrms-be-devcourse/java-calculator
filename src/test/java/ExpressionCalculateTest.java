import controller.dto.MathExpression;
import exception.CalculatorException;
import model.calculator.Calculator;
import model.calculator.CalculatorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

public class ExpressionCalculateTest {
    private final Calculator calculator = new CalculatorImpl();

    @DisplayName(value = "정상적인 연산식 입력 테스트")
    @ParameterizedTest
    @CsvSource(
            {       "'0 + 1 + 2 - 5', -2",
                    "'10 * 2 / 2 - 0', 10",
                    "'100 + 50 * 2 - 100 / 50', 198",
                    "'10 + 100 / 5 * 2 * 4 - 5', 165",
                    "'-10 + -40 / -20', -8",
                    "'-10 - -40 * 3', 110",
                    "'-10 - -40 * -3', -130",
                    "'-10 * -5 + 10', 60",
            }
    )
    public void 성공_테스트(String expression, int expected) throws CalculatorException {
        int actual = calculator.calculate(MathExpression.from(expression));
        assertEquals(expected, actual);
    }


    @DisplayName(value = "비정상적 연산식 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"5 + 3 / 2 +", "10-20", "a - b"})
    public void 실패_테스트(String expression) throws CalculatorException {
        assertThrows(CalculatorException.class, () -> {
            calculator.calculate(MathExpression.from(expression));
        });
    }
}
