package com.programmers.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilTest {

    @Test
    @DisplayName("숫자인지 확인")
    void testValidNumber() throws Exception {
        assertTrue(StringUtil.isNumber("123"));
        assertTrue(StringUtil.isNumber("0"));
    }

    @Test
    @DisplayName("숫자외 형식")
    void testInvalidNumber() throws Exception {
        assertFalse(StringUtil.isNumber("asb"));
        assertFalse(StringUtil.isNumber("!@#$"));
        assertFalse(StringUtil.isNumber("-"));
        assertFalse(StringUtil.isNumber("."));
    }

    @Test
    @DisplayName("null 형식")
    void nullInput() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> StringUtil.isNumber(null));
    }
}