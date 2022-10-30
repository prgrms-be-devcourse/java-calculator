package calculator.domain;

import calculator.exception.DividedByZeroException;
import calculator.exception.InvalidOperatorException;
import calculator.repository.CalculatorRepository;
import calculator.repository.MapCalculatorRepository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorTest {

    Calculator calculator;
    CalculatorRepository calculatorRepository;

    @BeforeEach
    void set() {
        calculatorRepository = mock(MapCalculatorRepository.class);
        when(calculatorRepository.getResultFromExpression(any())).thenReturn(Optional.empty());
        calculator = new BaseCalculator(calculatorRepository);
    }

    @Test
    @DisplayName("[실패] 나누기 시에, 0으로 나누는 경우 예외를 반환")
    void calculate_divided0_fail() {
        String EXP_OF_DIV_BY_0 = "2 / 0";
        Assertions.assertThrows(DividedByZeroException.class, () -> {
            calculator.calculate(EXP_OF_DIV_BY_0);
        });
    }

    @Test
    @DisplayName("[실패] 지정된 연산자가 없을 경우, 예외를 반환")
    void calculate_invalid_operator_fail() {
        String EXP_OF_INVALID_OPERATOR = "2 ! 4";
        Assertions.assertThrows(InvalidOperatorException.class, () -> {
            calculator.calculate(EXP_OF_INVALID_OPERATOR);
        });
    }

    @Test
    @DisplayName("[성공] 연산자의 우선 순위가 다른 경우")
    void calculate_success() {
        String EXP_OF_ADD_N_DIV = "2 + 4 / 4";
        String ANSWER_OF_ADD_N_DIV = "3";

        String answer = calculator.calculate(EXP_OF_ADD_N_DIV);
        assertThat(answer).isEqualTo(ANSWER_OF_ADD_N_DIV);
    }

    @Test
    @DisplayName("[성공] 괄호를 사용한 연산식(괄호 안, 곱셈, 덧셈 순 연산)의 경우")
    void calculate_with_bracket_success() {
        String EXP_OF_BRACKET = "2 * (3 + 5)";
        String ANSWER_OF_BRACKET = "16";

        String answer = calculator.calculate(EXP_OF_BRACKET);
        assertThat(answer).isEqualTo(ANSWER_OF_BRACKET);
    }

    @Test
    @DisplayName("[성공] 이전에 계산한 이력이 있는 경우, 이력을 가져와 결과 반환")
    void calculate_with_history_success() {
        String EXP_OF_TEST = "2 + 4 / 4";
        String ANSWER_OF_TEST = "3";
        String CALCULATION_RESULT_HISTORY = "2+4/4 = 3";

        when(calculatorRepository.getResultFromExpression(EXP_OF_TEST)).thenReturn(Optional.of(CALCULATION_RESULT_HISTORY));

        String answer = calculator.calculate(EXP_OF_TEST);
        assertThat(answer).isEqualTo(ANSWER_OF_TEST);
    }
}
