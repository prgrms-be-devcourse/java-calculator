import com.calculator.Application;
import com.calculator.common.Calculator;
import com.calculator.io.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    static Console console;
    static Calculator calculator;

    @BeforeAll
    static void App() {
        console = new Console();

        calculator = Calculator.builder()
                .input(console)
                .output(console)
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
    void calculate(String input, int result) {
        int calculate = calculator.calculate(input);

        assertThat(calculate).isEqualTo(result);
    }

}
