package hyuk;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("뺄셈 기능 테스트")
    @Test
    void subtract() {
        //given
        //when
        int actual = calculator.subtract(1, 2);

        //then
        assertThat(actual).isEqualTo(-1);

    }

}
