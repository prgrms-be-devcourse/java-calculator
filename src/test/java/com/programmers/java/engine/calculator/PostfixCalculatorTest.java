package com.programmers.java.engine.calculator;

import com.programmers.java.engine.exception.OperatorException;
import com.programmers.java.engine.model.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostfixCalculatorTest {
    @Test
    @DisplayName("0으로 나누지 않는 후위 표현식 연산 테스트")
    public void calcTest() {
        Calculator calculator = new PostfixCalculator();
        Expression expression = new Expression("3 5 2 * 7 2 - / + ");
        int result = (int) calculator.calculate(expression);

        Assertions.assertEquals(result, 5);
    }

    @Test
    @DisplayName("0으로 나누는 후위 표현식 연산 테스트")
    public void calcTest2() {
        OperatorException exception = Assertions.assertThrows(OperatorException.class, () -> {
            Calculator calculator = new PostfixCalculator();
            Expression expression = new Expression("3 5 2 * 7 7 - / + ");
            int result = (int) calculator.calculate(expression);
        });

        Assertions.assertEquals(exception.getMessage(), "0 으로 나눌 수 없습니다.\n");
    }
}
