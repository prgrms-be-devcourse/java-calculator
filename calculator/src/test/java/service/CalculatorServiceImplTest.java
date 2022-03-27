package service;

import io.InputImpl;
import io.OutputImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.CalculatorRepositoryImpl;

class CalculatorServiceImplTest {

    CalculatorService calculatorService = new CalculatorServiceImpl(
            new CalculatorRepositoryImpl(),
            new InputImpl(),
            new OutputImpl());

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
    void _0으로_나눌때_계산_실패() {
        //given
        String postfix = "12+26/0";
        //then
        Assertions.assertThatThrownBy(() -> calculatorService.calculate(postfix))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없다");
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