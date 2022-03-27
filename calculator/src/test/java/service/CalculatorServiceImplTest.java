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
        //when
        //then
        System.out.println();
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
        Assertions.assertThat(plus_minus).isEqualTo(false);
        Assertions.assertThat(plus_divide).isEqualTo(true);
        Assertions.assertThat(minus_divide).isEqualTo(true);
        Assertions.assertThat(multiply_divide).isEqualTo(false);
    }
}