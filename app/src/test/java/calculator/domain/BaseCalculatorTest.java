package calculator.domain;

import calculator.repository.CalculatorRepository;
import calculator.repository.MapCalculatorRepository;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static calculator.Fixture.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseCalculatorTest {

    Calculation calculation = mock(BaseCalculation.class);
    CalculatorRepository calculatorRepository = mock(MapCalculatorRepository.class);
    Calculator calculator = new BaseCalculator(calculation, calculatorRepository);

    @Test
    void calculate_더하기랑빼기(){
        when(calculation.addition(1, 1)).thenReturn(2);
        when(calculation.subtraction(2, 5)).thenReturn(-3);

        int answer = calculator.calculate(EXPRESSION_add_min);
        assertThat(answer).isEqualTo(EXPRESSION_add_min_answer);
    }

    @Test
    void calculate_곱셈과나눗셈(){
        when(calculation.multiplication(2, 3)).thenReturn(6);
        when(calculation.division(6, 4)).thenReturn(1);

        int answer = calculator.calculate(EXPRESSION_div_mul);
        assertThat(answer).isEqualTo(EXPRESSION_div_mul_answer);
    }

    @Test
    void calculate_더하기와나눗셈(){
        when(calculation.addition(2, 1)).thenReturn(3);
        when(calculation.division(4, 4)).thenReturn(1);

        int answer = calculator.calculate(EXPRESSION_add_div);
        assertThat(answer).isEqualTo(EXPRESSION_add_div_answer);
    }

    @Test
    void calculate_괄호(){
        when(calculation.addition(3, 5)).thenReturn(8);
        when(calculation.multiplication(2, 8)).thenReturn(16);

        int answer = calculator.calculate(EXPRESSION_bracket);
        assertThat(answer).isEqualTo(EXPRESSION_bracket_answer);
    }
}
