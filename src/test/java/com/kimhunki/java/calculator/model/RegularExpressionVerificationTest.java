package com.kimhunki.java.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionVerificationTest {

    RegularExpressionVerification regularExpressionVerification = new RegularExpressionVerification();

    @DisplayName("정규표현식 검증 테스트")
    @Test
    void verify( ) {
        String test1 = "123++2"; // +두개
        String test2 = "12a+3"; // 영어
        String test3 = "323+14="; // = 넣은거
        String test4 = "123+42*54/1+6*54-33"; // 정상적인 식
        String test5 = "123.25+546*23.1/254-24"; // 소수 첨가

        assertTrue(regularExpressionVerification.verify(test1));
        assertTrue(regularExpressionVerification.verify(test2));
        assertTrue(regularExpressionVerification.verify(test3));
        assertFalse(regularExpressionVerification.verify(test4));
        assertFalse(regularExpressionVerification.verify(test5));

    }
}