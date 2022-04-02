package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.enums.Operations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    Operator operator = new Operator();
    @Test
    @DisplayName("계산 테스트")
    public void operate()
    {
        double num1 = 50;
        double num2 = 10;

        assertEquals(40,operator.operate(num1,num2,Operations.MINUS));
        assertEquals(500, operator.operate(num1,num2, Operations.MUL));
        assertEquals(60,operator.operate(num1,num2,Operations.PLUS));
        assertEquals(5,operator.operate(num1,num2,Operations.DIV));

    }
}