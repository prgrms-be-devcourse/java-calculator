package hyuk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("나눗셈 기능 테스트 - 정상 케이스")
    @Test
    void divide() {
        //given
        //when
        int actual = calculator.divide(6, 2);

        //then
        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("나눗셈 기능 테스트 - x / 0")
    @Test
    void divideError() {
        //given
        //when
        //then
        assertThatThrownBy(() -> calculator.divide(1, 0))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

}
