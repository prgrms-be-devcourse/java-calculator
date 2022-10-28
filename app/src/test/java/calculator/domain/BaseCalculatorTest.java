package calculator.domain;

import calculator.repository.CalculatorRepository;
import calculator.repository.MapCalculatorRepository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;

public class BaseCalculatorTest {
    CalculatorRepository calculatorRepository = mock(MapCalculatorRepository.class);
    Calculator calculator = new BaseCalculator(calculatorRepository);

    @Test
    void calculate_더하기랑빼기() {
        String EXP_OF_ADD_N_MIN = "1 + 1 - 5";
        String ANSWER_OF_ADD_N_MIN = "-3";

        String answer = calculator.calculate(EXP_OF_ADD_N_MIN);
        assertThat(answer).isEqualTo(ANSWER_OF_ADD_N_MIN);
    }

    @Test
    void calculate_0으로나누는경우() {
        String EXP_OF_DIV_BY_0 = "2 / 0";
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(EXP_OF_DIV_BY_0);
        });
    }

    @Test
    void calculate_곱셈과나눗셈() {
        String EXP_OF_DIV_N_MUL = "2 * 3 / 4";
        String ANSWER_OF_DIV_N_MUL = "1";

        String answer = calculator.calculate(EXP_OF_DIV_N_MUL);
        assertThat(answer).isEqualTo(ANSWER_OF_DIV_N_MUL);
    }

    @Test
    void calculate_더하기와나눗셈() {
        String EXP_OF_ADD_N_DIV = "2 + 4 / 4";
        String ANSWER_OF_ADD_N_DIV = "3";

        String answer = calculator.calculate(EXP_OF_ADD_N_DIV);
        assertThat(answer).isEqualTo(ANSWER_OF_ADD_N_DIV);
    }

    @Test
    void calculate_괄호() {
        String EXP_OF_BRACKET = "2 * (3 + 5)";
        String ANSWER_OF_BRACKET = "16";

        String answer = calculator.calculate(EXP_OF_BRACKET);
        assertThat(answer).isEqualTo(ANSWER_OF_BRACKET);
    }
}
