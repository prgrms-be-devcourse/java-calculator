package com.programmers.calculator.engine.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorValidatorTest {

    private final Validator validator = new CalculatorValidator();

    private boolean assertValidate(String s) {
        String inputString = s;
        return validator.validate(inputString);
    }

    @Test
    @DisplayName("숫자 혹은 operation이 아닌 문자가 들어오는 경우")
    void validate() {
        boolean validate = assertValidate("3 + dfs2 * 3");
        assertFalse(validate);
    }

    @Test
    @DisplayName("operation +-*/이 아닌 다른 문자가 들어오는 경우")
    void validate2() {
        boolean validate = assertValidate("3 > dfs2");
        assertFalse(validate);
    }
}