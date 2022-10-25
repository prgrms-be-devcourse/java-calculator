import com.calculator.Application;
import com.calculator.common.Calculator;
import com.calculator.io.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Console console;
    Calculator calculator;

    @BeforeAll
    void App() {
        this.console = new Console();

        this.calculator = Calculator.builder()
                .input(console)
                .output(console)
                .build();
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
