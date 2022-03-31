package com.programmers.java.engine.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.function.Supplier;

public class CalcServiceTest {
    CalcService calcService = new CalcService();
    @Test
    public void 잘못된_연산자_입력시_예외가_발생해야함(){
        // given
        Long a = 1L;
        Long b = 2L;
        String errorOperator = "a";
        Stack<Long> s = new Stack<>();
        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
           calcService.calcArithmetic(a,b,errorOperator,s);
        });
    }

    @Test
    public void 음수식이_들어왔을때_계산이_잘되어야함() {
        //given
        String negativeFormula[] = "2 3 -1 + -".split(" ");
        //when
        Long testResult = calcService.calculate(negativeFormula);
        //then
        Assertions.assertEquals(0, testResult);
    }
}
