package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    private Validation validation;

    @BeforeEach
    public void setValidation() {
        validation = new Validation();
    }

    @Test
    public void addNullAndEmptyString() {
        Assertions.assertFalse(validation.checkValid(null).isPresent());
        Assertions.assertFalse(validation.checkValid("\n").isPresent());
    }

    @Test
    public void addMoreBlankSpace() {
        Assertions.assertFalse(validation.checkValid("1     /      2\n").isPresent());
        Assertions.assertFalse(validation.checkValid("  1 / 2\n").isPresent());
    }

    @Test
    public void addTrueCase() {
        Assertions.assertTrue(validation.checkValid("1 / 2\n").isPresent());
        Assertions.assertTrue(validation.checkValid("1 + 2 * 3 - 4\n").isPresent());
        Assertions.assertTrue(validation.checkValid("1 / 5 + 4 / 5").isPresent());
    }

}
