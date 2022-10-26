package org.programmers.java.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {

    @Test
    @DisplayName("입력값에 올바르게 연산자가 반환되는지 검증하라")
    void from() {
        //given
        char charOperatorPlus = '+';
        char charOperatorMinus = '-';
        char charOperatorMultiply = '*';
        char charOperatorDivide = '/';

        //when
        Operator operatorPlus = Operator.from(charOperatorPlus);
        Operator operatorMinus = Operator.from(charOperatorMinus);
        Operator operatorMultiply = Operator.from(charOperatorMultiply);
        Operator operatorDivide = Operator.from(charOperatorDivide);

        //then
        assertEquals(Operator.PLUS, operatorPlus);
        assertEquals(Operator.MINUS, operatorMinus);
        assertEquals(Operator.MULTIPLY, operatorMultiply);
        assertEquals(Operator.DIVIDE, operatorDivide);
    }

    @Test
    @DisplayName("입력값에 따라서 정확하게 연산되는지 검증하라")
    void execute() {
        //given
        Double i1 = 1.0;
        Double i2 = 1.0;

        char charOperatorPlus = '+';
        char charOperatorMinus = '-';
        char charOperatorMultiply = '*';
        char charOperatorDivide = '/';

        Operator operatorPlus = Operator.from(charOperatorPlus);
        Operator operatorMinus = Operator.from(charOperatorMinus);
        Operator operatorMultiply = Operator.from(charOperatorMultiply);
        Operator operatorDivide = Operator.from(charOperatorDivide);

        //when
        final Double plusAnswer = operatorPlus.execute(i1, i2);
        final Double minusAnswer = operatorMinus.execute(i1, i2);
        final Double multiplyAnswer = operatorMultiply.execute(i1, i2);
        final Double divideAnswer = operatorDivide.execute(i1, i2);

        //then
        assertEquals(2.0, plusAnswer);
        assertEquals(0.0, minusAnswer);
        assertEquals(1.0, multiplyAnswer);
        assertEquals(1.0, divideAnswer);
    }
}