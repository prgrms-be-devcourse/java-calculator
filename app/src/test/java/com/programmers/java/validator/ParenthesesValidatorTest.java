package com.programmers.java.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesValidatorTest {

    ParenthesesValidator parenthesesValidator = new ParenthesesValidator();

    @DisplayName("괄호 검사기 true 판별")
    @Test
    void validate_true() {
        assertTrue(parenthesesValidator.validate("()"));
        assertTrue(parenthesesValidator.validate("(1+1)"));
        assertTrue(parenthesesValidator.validate("(1+(1+2))"));
    }

    @DisplayName("괄호 검사기 false 판별")
    @Test
    void validate_false() {
        assertFalse(parenthesesValidator.validate("("));
        assertFalse(parenthesesValidator.validate("((1+2)"));
        assertFalse(parenthesesValidator.validate("(((1+3)-4)"));
    }
}