package com.caculator;

import com.caculator.io.Console;
import com.caculator.repository.MemoryCalculatorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    MemoryCalculatorRepository repository = new MemoryCalculatorRepository();
    Console console = new Console();
    Calculator calculator = new Calculator(repository, console, console);

    @Test
    @DisplayName("덧셈 테스트")
    void plusTest() {
        //given
        String exp = "1 + 2 + 3";

        //when
        int result = calculator.executeCalculator(exp);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("뺼셈 테스트")
    void minusTest() {
        //given
        String exp = "20 - 10 - 5";

        //when
        int result = calculator.executeCalculator(exp);

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiTest() {
        //given
        String exp = "10 * 15 * 3";

        //when
        int result = calculator.executeCalculator(exp);

        //then
        assertThat(result).isEqualTo(450);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideTest() {
        //given
        String exp = "20 / 2 / 5";

        //when
        int result = calculator.executeCalculator(exp);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("우선 순위 연산 테스트")
    void priorityTest() {

        //given
        String exp1 = "1 + 2 * 3 + 4 / 2";
        String exp2 = "100 - 50 * 3 / 2 + 25";
        String exp3 = "100 * 50 / 20 - 35 / 5 * 4 + 10 * 5 * 2";

        //when
        int result1 = calculator.executeCalculator(exp1);
        int result2 = calculator.executeCalculator(exp2);
        int result3 = calculator.executeCalculator(exp3);

        //then
        assertThat(result1).isEqualTo(9);
        assertThat(result2).isEqualTo(50);
        assertThat(result3).isEqualTo(322);
    }

    @Test
    @DisplayName("0으로 나누면 ArithmeticException 발생")
    void divideZeroTest() {
        String exp1 = "3 / 0";
        String exp2 = "1 + 2 * 10 / 0 + 4";
        String exp3 = "3 * 4 / 0 * 5";

        Assertions.assertThrows(ArithmeticException.class, () -> calculator.executeCalculator(exp1));
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.executeCalculator(exp2));
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.executeCalculator(exp3));
    }

    @Test
    @DisplayName("숫자와 연산자(+,-,*,/) 외에 다른 문자가 있으면 IllegalArgumentException 발생")
    void otherCharTest() {
        String exp1 = "a b c d e f g";
        String exp2 = "1 + 2 * b / 0 + 4";
        String exp3 = "3 * @ / 0 * %";

        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.executeCalculator(exp1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.executeCalculator(exp2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.executeCalculator(exp3));
    }
}