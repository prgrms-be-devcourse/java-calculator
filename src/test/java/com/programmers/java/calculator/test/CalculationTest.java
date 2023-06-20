package com.programmers.java.calculator.test;

import com.programmers.java.calculator.engine.CalculatorEngine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {
    CalculatorEngine calculation = new CalculatorEngine();

    @Test
    void testCalculator() {
        //given
        String oper = "3+(4*2)-6";
        int result = 5;

        //when
        int answer = calculation.calPostfix(calculation.infixTopostfic(oper));

        //then
        assertEquals(result, answer);
    }

    @Test
    void testCalculatorAdd() {
        //given
        String oper = "3+2+9";
        int result = 14;

        //when
        int answer = calculation.calPostfix(calculation.infixTopostfic(oper));

        //then
        assertEquals(result, answer);
    }

    @Test
    void testCalculatorSub() {
        //given
        String oper = "7-5-3";
        int result = -1;

        //when
        int answer = calculation.calPostfix(calculation.infixTopostfic(oper));

        //then
        assertEquals(result, answer);
    }

    @Test
    void testCalculatorDiv() {
        //given
        String oper = "9/1/2";
        int result = 4;

        //when
        int answer = calculation.calPostfix(calculation.infixTopostfic(oper));

        //then
        assertEquals(result, answer);
    }


    @Test
    void testCalculatorMul() {
        //given
        String oper = "5*2*7";
        int result = 70;

        //when
        int answer = calculation.calPostfix(calculation.infixTopostfic(oper));

        //then
        assertEquals(result, answer);
    }


}
