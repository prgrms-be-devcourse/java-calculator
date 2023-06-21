package org.programmers.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.java.calculation.Operator;

import static org.junit.jupiter.api.Assertions.*;

public class OperatorTest {
    @Test
    @DisplayName("사칙연산 테스트")
    void operatorCalculate(){
        assertEquals(10, Operator.arithmeticExpression("+", 5, 5));
        assertEquals(3, Operator.arithmeticExpression("-", 5, 2));
        assertEquals(30, Operator.arithmeticExpression("*", 10, 3));
        assertEquals(5, Operator.arithmeticExpression("/", 40, 8));
    }
}
