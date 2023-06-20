package com.programmers.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @Test
    @DisplayName("올바른 위치에 연산자 유무 체크")
    void testOperatorPositionCheck() throws Exception {
        Assertions.assertTrue(Validator.isOperatorCheck(1));
        Assertions.assertTrue(Validator.isOperatorCheck(3));

        Assertions.assertFalse(Validator.isOperatorCheck(0));
        Assertions.assertFalse(Validator.isOperatorCheck(2));
    }

    @Test
    @DisplayName("빈칸 체크")
    void testCheckEmpty() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkEmpty(new String[0]));

        assertDoesNotThrow(() -> Validator.checkEmpty(new String[]{"1,", "+", "2"}));
    }
    @Test
    @DisplayName("null 체크")
    void testCheckNull() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkNull(null));
        assertDoesNotThrow(() -> Validator.checkNull("1 + 2"));
    }
}