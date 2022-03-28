package service;

import io.Input;
import io.Output;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator = new Calculator(
            new InMemoryRepository(),
            new Input(),
            new Output(),
            new Validator());

    @Test
    void 중위표기식_후위표기식_변환() {
        //given
        String expFirst = "12 + 22 * 6";
        String expSecond = "-77 / 22 / 6";
        String expThird = "-1 - -5";
        //when
        ArrayList<Object> listFirst = calculator.toPostfix(expFirst);
        ArrayList<Object> listSecond = calculator.toPostfix(expSecond);
        ArrayList<Object> listThird = calculator.toPostfix(expThird);
        //then
        assertThat(listFirst).containsExactly(12.0, 22.0, 6.0, "*", "+");
        assertThat(listSecond).containsExactly(-77.0, 22.0, "/", 6.0, "/");
    }

    @Test
    void 후위표기식_계산() {
        //given
        String postfix = "12 * 26 * 6";
        //when
        double result = calculator.calculate(postfix);
        //then
        assertThat(result).isEqualTo(1872.0);
    }

    @Test
    void _0으로_나눌_계산_실패() {
        //given
        String postfix = "12 + 26 / 0";
        //then
        Assertions.assertThatThrownBy(() -> calculator.calculate(postfix))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void 두개의_연속된_수식일때_계산_실패() {
        //given
        String postfix = "12 ++ 26 / 0";
        //then
        Assertions.assertThatThrownBy(() -> calculator.calculate(postfix))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 숫자_문자_개수가_맞지_않을때_계산_실패() {
        //given
        String postfix = "12 + 26 *";
        //then
        Assertions.assertThatThrownBy(() -> calculator.calculate(postfix))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_입력시_계산_실패() {
        //given
        String postfix = "";
        //then
        Assertions.assertThatThrownBy(() -> calculator.calculate(postfix))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 이상한_수식일때_계산_실패() {
        //given
        String postfix = "12 ++ 26 / 0";
        //then
        Assertions.assertThatThrownBy(() -> calculator.calculate(postfix))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 정해진_수식이_아닌_문자일때_계산_실패() {
        //given
        String postfix = "12 i 26 / 0";
        //then
        Assertions.assertThatThrownBy(() -> calculator.calculate(postfix))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void 우선순위_비교() {
        //given
        String plus = "+";
        String minus = "-";
        String multiply = "*";
        String divide = "/";
        //when
        boolean plusMinus = calculator.checkPriority(plus, minus);
        boolean plusDivide = calculator.checkPriority(plus, divide);
        boolean minueDivide = calculator.checkPriority(minus, divide);
        boolean multipitDivide = calculator.checkPriority(multiply, divide);

        //then
        assertThat(plusMinus).isEqualTo(true);
        assertThat(plusDivide).isEqualTo(false);
        assertThat(minueDivide).isEqualTo(false);
        assertThat(multipitDivide).isEqualTo(true);
    }
}