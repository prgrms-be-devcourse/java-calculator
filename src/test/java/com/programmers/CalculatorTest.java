package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() throws Exception {
        //given
        Calculator calculator = new Calculator("1 + 1");
        Calculator calculator2 = new Calculator("2 + 2");
        //when
        long result = calculator.calculate("1 + 1");
        long result2 = calculator2.calculate("2 + 2");

        //then
        assertThat(result).isEqualTo(2);
        assertThat(result2).isEqualTo(4);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractTest() throws Exception {
        //given
        Calculator calculator = new Calculator("1 - 1");
        //when
        long result = calculator.calculate("1 - 1");
        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiplyTest() throws Exception {
        //given
        Calculator calculator = new Calculator("2 * 2 * 3");
        //when
        long result = calculator.calculate("2 * 2 * 3");
        //then
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divideTest() throws Exception {
        //given
        Calculator calculator = new Calculator("6 / 2 / 3");
        //when
        long result = calculator.calculate("6 / 2 / 3");
        //then
        assertThat(result).isEqualTo(1);
    }


    @Test
    @DisplayName("우선 순위 테스트")
    void priorityTest() throws Exception {
        //given
        Calculator calculator = new Calculator("2 + 2 * 3 / 3");

        //when
        long result = calculator.calculate("2 + 2 * 3 / 3");

        //then
        assertThat(result).isEqualTo(4);
    }


    @ParameterizedTest
    @ValueSource(strings = {"2 / 0 ", "1 + 3 * 10 / 0", "2 - 3 + 2 / 0 * 5"})
    @DisplayName("0으로 나눌시 예외 발생 테스트")
    void divideZeroTest(String formula) throws Exception {
        Calculator calculator = new Calculator(formula);

        Assertions.assertThrows(ArithmeticException.class, () -> calculator.calculate(formula));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1 + a", "2  2", "1 + +", "a B C d"})
    @DisplayName("숫자,연산외 다른 문자 입력시 예외")
    void wrongFormulaTest(String formula) throws Exception {
        Calculator calculator = new Calculator(formula);

        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculate(formula));


    }

}
