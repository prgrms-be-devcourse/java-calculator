package com.caculator;

import com.caculator.io.Console;
import com.caculator.repository.MemoryCalculatorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    MemoryCalculatorRepository repository = new MemoryCalculatorRepository();
    Console console = new Console();
    Calculator calculator = new Calculator(repository, console, console);

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        //given
        String expression = "1 + 2 + 3";

        //when
        long result = calculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("뺼셈 테스트")
    void subtractTest() {
        //given
        String expression = "20 - 10 - 5";

        //when
        long result = calculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiTest() {
        //given
        String expression = "10 * 15 * 3";

        //when
        long result = calculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(450);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideTest() {
        //given
        String expression = "20 / 2 / 5";

        //when
        long result = calculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("우선 순위 연산 테스트")
    void priorityTest() {

        //given
        String expression1 = "1 + 2 * 3 + 4 / 2";
        String expression2 = "100 - 50 * 3 / 2 + 25";
        String expression3 = "100 * 50 / 20 - 35 / 5 * 4 + 10 * 5 * 2";

        //when
        long result1 = calculator.calculate(expression1);
        long result2 = calculator.calculate(expression2);
        long result3 = calculator.calculate(expression3);

        //then
        assertThat(result1).isEqualTo(9);
        assertThat(result2).isEqualTo(50);
        assertThat(result3).isEqualTo(322);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 / 0", "1 + 2 * 10 / 0 + 4", "3 * 4 / 0 * 5"})
    @DisplayName("0으로 나누면 ArithmeticException 발생")
    void divideZeroTest(String expression) {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.calculate(expression));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a b c d e f g", "1 + 2 * b / 0 + 4", "3 * @ / 0 * %"})
    @DisplayName("숫자와 연산자(+,-,*,/) 외에 다른 문자가 있으면 IllegalArgumentException 발생")
    void otherCharTest(String expression) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculate(expression));
    }
}