package com.programmers.java.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FormValidatorTest {

    static final FormValidator formValidator = new FormValidator();

    @DisplayName("올바른 입력 형식 판별")
    @Test
    void validate_success() {
        assertTrue(formValidator.validate("1 + 3"));
        assertTrue(formValidator.validate("( 1 * ( 1 + 3 ) ) "));
        assertTrue(formValidator.validate("( 1 * ( 1 + 3 ) - 1 ) "));
    }

    @DisplayName("잘못된 입력 형식 판별")
    @Test
    void validate_fail() {
        assertFalse(formValidator.validate("1+3 "));
        assertFalse(formValidator.validate("1 + (3 + 5"));
        assertFalse(formValidator.validate("1 + 3 +4"));
    }
}