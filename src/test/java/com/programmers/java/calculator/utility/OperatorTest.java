package com.programmers.java.calculator.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class OperatorTest {
    Operator operator = new ArithmeticOperator();
    @Test
    @DisplayName("후위 표기식 덧셈")
    void postfixAddTest(){
        //given
        String postfixExp = "1.0 2.5 +";

        //when
        double result = operator.calculate(postfixExp);

        //then
        assertThat(result).isEqualTo(3.5);
    }

    @Test
    @DisplayName("후위 표기식 뺄셈")
    void postfixSubtractTest(){
        //given
        String postfixExp = "1.0 2.5 -";

        //when
        double result = operator.calculate(postfixExp);

        //then
        assertThat(result).isEqualTo(-1.5);
    }

    @Test
    @DisplayName("후위 표기식 곱셈")
    void postfixMultiplyTest(){
        //given
        String postfixExp = "1.0 2.5 *";

        //when
        double result = operator.calculate(postfixExp);

        //then
        assertThat(result).isEqualTo(2.5);
    }

    @Test
    @DisplayName("후위 표기식 나눗셈")
    void postfixDivideTest(){
        //given
        String postfixExp = "1.0 2.0 /";

        //when
        double result = operator.calculate(postfixExp);

        //then
        assertThat(result).isEqualTo(0.5);
    }

    @Test
    @DisplayName("후위 표기식 복잡한 식 테스트")
    void postfixMultiTest(){
        //given
        String postfixExp1 = "4 7 2 + *";
        String postfixExp2 = "1 5 / 2 4 - *";

        //when
        double result1 = operator.calculate(postfixExp1);
        double result2 = operator.calculate(postfixExp2);

        //then
        assertThat(result1).isEqualTo(36);
        assertThat(result2).isEqualTo(-0.4);
    }
}