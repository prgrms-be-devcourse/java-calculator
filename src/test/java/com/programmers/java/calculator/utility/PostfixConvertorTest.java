package com.programmers.java.calculator.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PostfixConvertorTest {
    PostfixConvertor postfixConvertor = new ArithmeticPostfixConvertor();

    @Test
    @DisplayName("이항 테스트")
    void binomialTest(){
        //given
        String exp = "1.0 + 2.5";

        //when
        String postfixExp = postfixConvertor.setPostfix(exp);

        //then
        assertThat(postfixExp).isEqualTo("1.0 2.5 +");
    }

    @Test
    @DisplayName("다항 테스트")
    void polynomialTest(){
        //given
        String exp = "1.0 + 2.5 + 2.1";

        //when
        String postfixExp = postfixConvertor.setPostfix(exp);

        //then
        assertThat(postfixExp).isEqualTo("1.0 2.5 + 2.1 +");
    }

    @Test
    @DisplayName("우선순위 테스트")
    void priorityTest(){
        //given
        String exp = "1.0 + 2.5 * 2.1";

        //when
        String postfixExp = postfixConvertor.setPostfix(exp);

        //then
        assertThat(postfixExp).isEqualTo("1.0 2.5 2.1 * +");
    }
}