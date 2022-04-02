package com.programmers.java.engine;

import com.programmers.java.OperationImpl;
import com.programmers.java.engine.domain.Expression;
import com.programmers.java.engine.domain.Operand;
import com.programmers.java.engine.domain.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class CalculatorTest {
    Calculator calculator = new Calculator(new OperationImpl());

    @Test
    @DisplayName("입력 변환 테스트")
    public void parseInputTest() {
        String inputStr = "1+2*3-4/2";
        Expression expression = calculator.parseInput(inputStr);
        Assertions.assertThat(expression.getOperands()).isEqualTo(List.of(
                new Operand(1.0),
                new Operand(2.0),
                new Operand(3.0),
                new Operand(4.0),
                new Operand(2.0)));
        Assertions.assertThat(expression.getOperators()).isEqualTo(List.of(
                Operator.PLUS, Operator.MULTIPLY, Operator.MINUS, Operator.DIVIDE));
    }

    @Test
    @DisplayName("곱셈 나눗셈 테스트. 1")
    public void multiplyAndDivideTest() {
        String inputStr = "1+2*3-4/2";
        Double result = calculator.calculate(inputStr);
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("곱셈 나눗셈 테스트. 2")
    public void multiplyAndDivideTest2() {
        String inputStr = "1*2*3*4/2";
        Double result = calculator.calculate(inputStr);
        Assertions.assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("곱셈 나눗셈 테스트. 3")
    public void multiplyAndDivideTest3() {
        String inputStr = "1*2*3*4/0";
        try {
            Double result = calculator.calculate(inputStr);
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("0으로 나누는 것은 안됩니다.");
        }
    }

    @Test
    @DisplayName("덧셈 뺄셈 테스트")
    public void addAndSubtractTest() {
        String inputStr = "1+2-4";
        Double result = calculator.calculate(inputStr);
        Assertions.assertThat(result).isEqualTo(-1.0);
    }
}
