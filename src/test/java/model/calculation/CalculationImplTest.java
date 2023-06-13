package model.calculation;

import model.vo.CalculationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculationImplTest {

    @Test
    @DisplayName("후위연산 테스트")
    void calculate() {
        //given
        final Calculation calculation = new CalculationImpl();
        final CalculationResult calculationResult = new CalculationResult(8);
        final List<String> postfixExpression = List.of("3", "2", "4", "*", "+", "9", "3", "/", "-");

        //when
        CalculationResult result = calculation.calculate(postfixExpression);

        //then
        assertThat(result.getCalculationResult())
                .isEqualTo(calculationResult.getCalculationResult());
    }
}
