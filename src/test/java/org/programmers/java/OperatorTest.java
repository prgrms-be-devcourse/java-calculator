package org.programmers.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.java.calculation.Operator;

public class OperatorTest {

    @Test
    @DisplayName("사칙연산 테스트")
    void operatorCalculate(){
        Assertions.assertEquals(10, Operator.arithmeticExpression("+", 5, 5));
        Assertions.assertEquals(3, Operator.arithmeticExpression("-", 5, 2));
        Assertions.assertEquals(30, Operator.arithmeticExpression("*", 10, 3));
        Assertions.assertEquals(5, Operator.arithmeticExpression("/", 40, 8));
    }
}
