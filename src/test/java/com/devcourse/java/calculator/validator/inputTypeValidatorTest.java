package com.devcourse.java.calculator.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class inputTypeValidatorTest {

    @Test
    @DisplayName("연산자 정규표현식 확인")
    void isOperatorTest() {
        //given
        String test1 = "+";
        String test2 = "++";
        String test3 = "+*";

        //when
        boolean result1 = TypeValidator.isOperator(test1);
        boolean result2 = TypeValidator.isOperator(test2);
        boolean result3 = TypeValidator.isOperator(test3);

        //then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
        assertThat(result3).isEqualTo(false);

    }
}