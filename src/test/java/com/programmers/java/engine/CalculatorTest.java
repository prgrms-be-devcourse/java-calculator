package com.programmers.java.engine;

import com.programmers.java.OperationImpl;
import com.programmers.java.engine.domain.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CalculatorTest {
    Calculator calculator = new Calculator(new OperationImpl());

    @Test
    @DisplayName("입력 변환 테스트")
    public void parseInputTest(){
        String inputStr = "1+2*3-4/2";
        Expression expression = calculator.parseInput(inputStr);
        Assertions.assertThat(expression.getOperands()).isEqualTo(new Double[]{1.0, 2.0, 3.0, 4.0, 2.0});
        Assertions.assertThat(expression.getOperators()).isEqualTo(new String[]{"+", "*", "-", "/"});
    }

    @Test
    @DisplayName("곱셈 나눗셈 테스트. 1")
    public void multiplyAndDivideTest(){
        String inputStr = "1+2*3-4/2";
        Double result = calculator.calculate(inputStr);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("곱셈 나눗셈 테스트. 2")
    public void multiplyAndDivideTest2(){
        String inputStr = "1*2*3*4/2";
        Double result = calculator.calculate(inputStr);
        Assertions.assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("덧셈 뺄셈 테스트")
    public void addAndSubtractTest(){
        String inputStr = "1+2-4";
        Double result = calculator.calculate(inputStr);
        Assertions.assertThat(result).isEqualTo(-1.0);
    }
}
