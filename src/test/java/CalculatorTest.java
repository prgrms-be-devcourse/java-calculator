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
    @CsvSource(value = {"(1 + 2) / (5 - 3), 12+53-/", "1 + 2 * 4 - 2, 124*+2-", "2 * ( 6 / 3 + 7), 263/7+*"})
    @DisplayName("중위표기법 -> 후위표기법 변환")
    void change(String input, String after) {
        String change = calculator.change(input);

        assertThat(change).isEqualTo(after);
    }

    @Test
    @DisplayName("사칙연산 계산")
    void sum() {
        // +
        String input = "1 + 2";

        // -
        String input2 = "3 - 1";

        // *
        String input3 = "3 * 8";

        // /
        String input4 = "9 / 3";

        int answer = calculator.calculate(input);
        int answer2 = calculator.calculate(input2);
        int answer3 = calculator.calculate(input3);
        int answer4 = calculator.calculate(input4);

        assertThat(answer).isEqualTo(3);
        assertThat(answer2).isEqualTo(2);
        assertThat(answer3).isEqualTo(24);
        assertThat(answer4).isEqualTo(3);
    }

}
