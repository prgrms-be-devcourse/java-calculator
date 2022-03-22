package hyuk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("덧셈 기능 테스트")
    @Test
    void add() {
        //given
        //when
        int actual = calculator.add(1, 2);

        //then
        Assertions.assertThat(actual).isEqualTo(3);
    }

}
