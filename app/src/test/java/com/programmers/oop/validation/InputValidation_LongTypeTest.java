package com.programmers.oop.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidation_LongTypeTest {

    private Validation validation = new InputValidation_LongType();

    @Test
    @DisplayName("연산자를 포함한 식이 적절한지")
    void verifyExpression() {
        //given
        final String expression = "1 + 2 * 3";

        //when
        String answer = validation.verifyExpression(expression);
        //then
        Assertions.assertEquals(expression, answer);
    }

    @Test
    @DisplayName("숫자로 이루어지지 않는 경우 유효성 실패")
    public void verifyExpression_False() {
        //given
        String NotNumeric = "123+ 31231+ ddddd123";
        //when, then
        Assertions.assertThrows(RuntimeException.class,
            () -> validation.verifyExpression(NotNumeric));

    }

    /**
     * bug : 유효성 검증 버그
     */
    @Test
    @DisplayName("앞단과 끝에 연산자로 끝나느 경우 유효성 검증")
    public void verifyExpression_False2() {
        //given
        String data1 = "+12312-21313";
        String data2 = "12312-21313+";
        String answer1 = validation.verifyExpression(data1);
        String answer2 = validation.verifyExpression(data2);
        //when, then
        Assertions.assertThrows(RuntimeException.class,
            () -> validation.verifyExpression(data1));
        Assertions.assertThrows(RuntimeException.class,
            () -> validation.verifyExpression(data2));

    }


    /**
     * bug : 유효성 검증 버그
     */
    @Test
    @DisplayName("앞단과 끝에 연산자로 끝나느 경우 유효성 검증")
    public void verifyExpression_False3() {
        //given
        String data = "+12++3//12-21313";
        String answer = validation.verifyExpression(data);
        //when, then
        Assertions.assertThrows(RuntimeException.class,
            () -> validation.verifyExpression(data));

    }

}