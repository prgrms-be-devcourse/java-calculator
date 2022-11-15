package com.programmers.java.engine.calculator;

import com.programmers.java.engine.exception.OperatorException;
import com.programmers.java.engine.model.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostfixCalculatorTest {
    @Test
    @DisplayName("0으로 나누지 않는 경우 연산이 정상적으로 이루어지는지 테스트")
    public void nonDivideByZeroTest() {
        Calculator calculator = new PostfixCalculator(Integer.class);
        Expression expression = new Expression("3 5 2 * 7 2 - / + ");
        Number result = calculator.calculate(expression);

        Assertions.assertEquals(result, 5);
    }

    @Test
    @DisplayName("0으로 나누는 경우 예외가 발생하는지 테스트")
    public void divideByZeroTest() {
        Assertions.assertThrows(OperatorException.class, () -> {
            Calculator calculator = new PostfixCalculator(Integer.class);
            Expression expression = new Expression("3 5 2 * 7 7 - / + ");
            Number result = calculator.calculate(expression);
        });
    }
}
