import com.calculator.common.BaseException;
import com.calculator.common.Calculator;
import com.calculator.common.ValidatorHandler;
import com.calculator.io.Console;
import com.calculator.repository.MapRepository;
import com.calculator.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import static com.calculator.common.ExceptionStatus.DIVIDE_ZERO_ERROR;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Console console;
    private Calculator calculator;
    private Repository repository;
    private ValidatorHandler validatorHandler;

    @BeforeEach
    void App() {
        console = new Console(validatorHandler);

        calculator = new Calculator(console, console, repository, validatorHandler);

    }

    @ParameterizedTest
    @CsvSource(value = {"(2 + 4) / (6 - 3), 24+63-/", "1 + 2 * 4 - 2, 124*+2-", "2 * ( 6 / 3 + 7), 263/7+*"})
    @DisplayName("중위표기법 -> 후위표기법 변환")
    void change(String input, String after) {
        String change = calculator.changePostfix(input);

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
    void divZero() {
        try {
            calculator.calculate("4 / 0");
        } catch (BaseException e) {
            assertThat(e.getStatus().getMessage()).isEqualTo(DIVIDE_ZERO_ERROR.getMessage());
        }
    }

    @Test
    void df() {
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);

        s.remove(0);
        for (Integer ss : s) {
            System.out.println(ss);
        }
    }
}
