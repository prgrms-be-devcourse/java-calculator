package hyuk.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import hyuk.model.Operands;
import hyuk.model.Operators;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

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

    @DisplayName("곱셈 기능 테스트")
    @Test
    void multiply() {
        //given
        //when
        int actual = calculator.multiply(5, 5);

        //then
        assertThat(actual).isEqualTo(25);
    }

    @DisplayName("우선순위 연산 기능 개발")
    @Timeout(value = 1)
    @Test
    void calculate() {
        //given
        Operands operands = new Operands("1 + 2 * 3 + 4");
        Operators operators = new Operators("1 + 2 * 3 + 4");

        //when
        //then
        assertTimeoutPreemptively(Duration.ofMillis(2000),
            () -> assertThat(calculator.calculate(operands, operators).showResult()).isEqualTo(11));
    }

}
