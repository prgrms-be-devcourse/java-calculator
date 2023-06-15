package model.calculation;

import model.vo.CalculationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculationImplTest {
    private final CalculationImpl calculation = new CalculationImpl();

    @Test
    @DisplayName("후위연산 테스트")
    void calculate1() {
        //given
        final CalculationResult calculationResult = new CalculationResult(8);
        final List<String> postfixExpression = List.of("3", "2", "4", "*", "+", "9", "3", "/", "-");

        //when
        CalculationResult result = calculation.calculate(postfixExpression);

        //then
        assertThat(result.getCalculationResult())
                .isEqualTo(calculationResult.getCalculationResult());
    }

    @Test
    @DisplayName("후위연산 테스트")
    void calculate2() {
        //given
        final CalculationResult calculationResult = new CalculationResult(2);
        final List<String> postfixExpression = List.of("5", "2", "*", "8", "-");

        //when
        CalculationResult result = calculation.calculate(postfixExpression);

        //then
        assertThat(result.getCalculationResult())
                .isEqualTo(calculationResult.getCalculationResult());
    }

    @Test
    @DisplayName("후위연산 테스트")
    void calculate3() {
        //given
        final CalculationResult calculationResult = new CalculationResult(10);
        final List<String> postfixExpression = List.of("7", "3", "/", "2", "4", "*", "+");

        //when
        CalculationResult result = calculation.calculate(postfixExpression);

        //then
        assertThat(result.getCalculationResult())
                .isEqualTo(calculationResult.getCalculationResult());
    }
}
