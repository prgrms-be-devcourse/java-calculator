package com.wonu606.validator;

import static org.assertj.core.api.Assertions.assertThat;

import com.wonu606.calculator.validator.InfixValidator;
import com.wonu606.calculator.validator.Validator;
import org.junit.jupiter.api.Test;

public class InfixValidatorTest {

    @Test
    void testNotInfix() {
        // given
        Validator validator = new InfixValidator();

        // when
        String expression = "+ 1 3";

        // then
        assertThat(validator.isValid(expression)).isFalse();
    }

    @Test
    void testInfix() {
        // given
        Validator validator = new InfixValidator();

        // when
        String expression = "1 + 3 + 2 * -3 / -123";

        // then
        assertThat(validator.isValid(expression)).isTrue();
    }
}
