package service;

import io.InputImpl;
import io.OutputImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.CalculatorRepositoryImpl;

import java.util.EmptyStackException;

class CalculatorServiceImplTest {

    CalculatorService calculatorService = new CalculatorServiceImpl(
            new CalculatorRepositoryImpl(),
            new InputImpl(),
            new OutputImpl(),
            new ValidatorImpl());

    @Test
    void 중위표기식_후위표기식_변환() {
        //given
        String exp = "12+22*6";
        //when
        String toPostFix = calculatorService.toPostfix(exp).toString();
        //then
        Assertions.assertThat(toPostFix).isEqualTo("[12.0, 22.0, 6.0, *, +]");
    }

    @Test
    void 후위표기식_계산() {
        //given
        String postfix = "12+26*6";
        //when
        double result = calculatorService.calculate(postfix);
        //then
        Assertions.assertThat(result).isEqualTo(168);
    }

    @Test
    void _0으로_나눌_계산_실패() {
        //given
        String postfix = "12+26/0";
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(postfix))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없다");
    }
    @Test
    void 두개의_연속된_수식일때_계산_실패() {
        //given
        String postfix = "12++26/0";
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(postfix))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력하세요");
    }

    @Test
    void 숫자_문자_개수가_맞지_않을때_계산_실패() {
        //given
        String postfix = "12+26*";
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(postfix))
                .isInstanceOf(EmptyStackException.class);
    }

    @Test
    void 빈_문자열_입력시_계산_실패() {
        //given
        String postfix = "";
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(postfix))
                .isInstanceOf(EmptyStackException.class);
    }

    @Test
    void 이상한_수식일때_계산_실패() {
        //given
        String postfix = "12++26/0";
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(postfix))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력하세요");
    }

    @Test
    void 정해진_수식이_아닌_문자일때_계산_실패() {
        //given
        String postfix = "12i26/0";
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(postfix))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 수식을 입력하세요");
    }

    @Test
    void 우선순위_비교() {
        //given
        Character plus = '+';
        Character minus = '-';
        Character multiply = '*';
        Character divide = '/';
        //when
        boolean plus_minus = calculatorService.checkPriority(plus, minus);
        boolean plus_divide = calculatorService.checkPriority(plus, divide);
        boolean minus_divide = calculatorService.checkPriority(minus, divide);
        boolean multiply_divide = calculatorService.checkPriority(multiply, divide);

        //then
        Assertions.assertThat(plus_minus).isEqualTo(true);
        Assertions.assertThat(plus_divide).isEqualTo(false);
        Assertions.assertThat(minus_divide).isEqualTo(false);
        Assertions.assertThat(multiply_divide).isEqualTo(true);
    }
}