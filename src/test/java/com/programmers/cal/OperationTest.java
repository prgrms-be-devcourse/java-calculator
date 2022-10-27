package com.programmers.cal;

import com.programmers.cal.engine.operation.Operation;
import com.programmers.cal.engine.operation.OperationManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {

    Operation operation = new OperationManager();

    @Test
    @DisplayName("더하기만 있는 연산")
    public void successCalculate1() {
        //given
        List<String> input = Arrays.asList("12", "3", "+", "45", "+");
        String expected = "60.0";

        //when
        String result = operation.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("빼기만 있는 연산")
    public void successCalculate2() {
        //given
        List<String> input = Arrays.asList("12", "3", "-", "45", "-");
        String expected = "-36.0";

        //when
        String result = operation.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("곱하기만 있는 연산")
    public void successCalculate3() {
        //given
        List<String> input = Arrays.asList("12", "3", "*", "2", "*");
        String expected = "72.0";

        //when
        String result = operation.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("나누기만 있는 연산")
    public void successCalculate4() {
        //given
        List<String> input = Arrays.asList("45", "3", "/", "5", "/");
        String expected = "3.0";

        //when
        String result = operation.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙연산")
    public void successCalculate5() {
        //given
        List<String> input1 = Arrays.asList("12", "3", "45", "*", "2", "/", "+");
        List<String> input2 = Arrays.asList("12", "34", "2", "*", "+");

        String expected1 = "79.5";
        String expected2 = "80.0";

        //when
        String result1 = operation.calculate(input1);
        String result2 = operation.calculate(input2);

        //then
        assertThat(result1).isEqualTo(expected1);
        assertThat(result2).isEqualTo(expected2);
    }

    @Test
    @DisplayName("음수가 포함된 연산")
    public void successCalculate6() {
        //given
        List<String> input1 = Arrays.asList("-12", "-32", "-4", "/", "+");
        List<String> input2 = Arrays.asList("-12", "-32", "-4", "/", "+", "32", "2", "*", "+");

        String expected1 = "-4.0";
        String expected2 = "60.0";

        //when
        String result1 = operation.calculate(input1);
        String result2 = operation.calculate(input2);

        //then
        assertThat(result1).isEqualTo(expected1);
        assertThat(result2).isEqualTo(expected2);
    }


    @Test
    @DisplayName("0으로 나누기")
    public void checkZeroDivision() {

        try {
            List<String> input = Arrays.asList("12", "32", "0", "/", "+");
            operation.calculate(input);
        } catch (ArithmeticException e) {
            assertThat(e.getMessage()).isEqualTo("0으로 나눌 수 없음");
        }
    }
}