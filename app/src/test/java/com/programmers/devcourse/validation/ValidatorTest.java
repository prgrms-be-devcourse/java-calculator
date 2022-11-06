package com.programmers.devcourse.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    static Validator validator;

    @BeforeAll
    static void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("정수일때 정수 정규식 테스트")
    void isNumber() {
        assertTrue(validator.isNumber("143"));
    }

    @Test
    @DisplayName("실수일 때 정수 정규식 테스트")
    void isRealNumber() {
        assertFalse(validator.isNumber("0.0"));
    }

    @Test
    @DisplayName("문자일 때 정수 정규식 테스트")
    void isString() {
        assertFalse(validator.isNumber("Tina"));
    }

    @Test
    @DisplayName("유효한 토큰 테스트")
    void isValidToken() {
        assertTrue(validator.validate("((1+2)*3)"));
    }

    @Test
    @DisplayName("유효하지 않은 토큰 테스트")
    void isNotValidToken() {
        assertFalse(validator.isValidToken("!.!><"));
    }
}