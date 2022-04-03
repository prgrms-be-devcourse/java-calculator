package hyuk.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("우선순위 연산 기능 테스트")
    @Test
    void calculateFormula() {
        //given
        PostOrderFormula postOrderFormula = new PostOrderFormula("1 + 2 * 3 + 4");

        //when
        Result result = calculator.calculates(postOrderFormula);

        //then
        assertThat(result.showResult()).isEqualTo(11);
    }

}
