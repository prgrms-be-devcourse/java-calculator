package calculator;

import com.programmers.java.calculator.ArithmeticModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculationTest {

    private final ArithmeticModule arithmeticModule = new ArithmeticModule();

    @ParameterizedTest
    @CsvSource({
            "11 + 11 - 11 * 11 / 11, 11",
            "-4 * -3 + -4 + 10, 18",
            "5 * 3 - 11 + 4, 8",
    })
    @DisplayName("정수로만 이루어진 식 계산하기")
    public void integerCalculationTest(String expression, String calculationResult){
        String compareValue = arithmeticModule.execute(expression);
        assertThat(compareValue).isEqualTo(calculationResult);
    }

    @ParameterizedTest
    @CsvSource({
            "1.5 * 4.5 / 3, 2.25",
            "-4.53 + 10.21 * 1.23, 8.03"
    })
    @DisplayName("실수를 포함한 식 계산하기")
    public void realNumberCalculationTest(String expression, String calculationResult){
        String compareValue = arithmeticModule.execute(expression);
        assertThat(compareValue).isEqualTo(calculationResult);
    }
}
