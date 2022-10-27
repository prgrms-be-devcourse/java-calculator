import com.calculator.common.BaseException;
import com.calculator.common.Calculator;
import com.calculator.common.ValidatorHandler;
import com.calculator.io.Console;
import com.calculator.repository.MapRepository;
import com.calculator.repository.Repository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.calculator.common.ExceptionStatus.DIVIDE_ZERO_ERROR;
import static com.calculator.common.ExceptionStatus.NOT_NUM_ERROR;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    static Console console;
    static Calculator calculator;
    static Repository repository;
    static ValidatorHandler validatorHandler;

    @BeforeAll
    static void App() {
        console = new Console(validatorHandler);

        calculator = Calculator.builder()
                .input(console)
                .output(console)
                .repository(new MapRepository())
                .build();
    }

    @ParameterizedTest
    @CsvSource(value = {"(2 + 4) / (6 - 3), 24+63-/", "1 + 2 * 4 - 2, 124*+2-", "2 * ( 6 / 3 + 7), 263/7+*"})
    @DisplayName("중위표기법 -> 후위표기법 변환")
    void change(String input, String after) {
        String change = calculator.change(input);

        assertThat(change).isEqualTo(after);
    }

    @ParameterizedTest
    @CsvSource(value = {"(2 + 4) / (6 - 3), 2", "1 + 2 * 4 - 2, 7", "2 * ( 6 / 3 + 7), 18"})
    @DisplayName("사칙연산 계산")
    void calculate(String input, double result) throws BaseException {
        double calculate = calculator.calculate(input);

        assertThat(calculate).isEqualTo(result);
    }

    @Test
    @DisplayName("0으로 나눴을 때 오류")
    void d() {
        try {
            calculator.calculate("4 / 0");
        } catch (BaseException e) {
            assertThat(e.getStatus().getMessage()).isEqualTo(DIVIDE_ZERO_ERROR.getMessage());
        }
    }
}
