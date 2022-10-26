package com.programmers.java.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathExpressionValidatorTest {

    @DisplayName("올바른 수식 판정")
    @Test
    void validate_success() {
        InputValidator mathExpressionValidator = new MathExpressionValidator();
        assertTrue(mathExpressionValidator.validate("1+3"));
        assertTrue(mathExpressionValidator.validate("(1+3+(1+2))"));
        assertTrue(mathExpressionValidator.validate("(1+3+(1+2)+3*7)"));
        assertTrue(mathExpressionValidator.validate("(1.11+3.3+(1+2)+3*7)"));
    }

    @DisplayName("잘못된 수식 판정")
    @Test
    void validate_fail() {
        InputValidator mathExpressionValidator = new MathExpressionValidator();
        assertFalse(mathExpressionValidator.validate("1+"));
        assertFalse(mathExpressionValidator.validate("(1+3(1+2))"));
        assertFalse(mathExpressionValidator.validate("(13..+(1+2)+3*7)"));
        assertFalse(mathExpressionValidator.validate("(13..+(1+2)+3**7)"));
    }

    @Test
    void printErrorMessage() {

    }
}