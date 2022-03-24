package com.calculator.java.domain.console;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {
    Validation validation = new Validation();

    @Test
    void 정상_수식_테스트() {
        String exp1 = "1 + 2 + 3";
        String exp2 = "3 - -2 + 3 * 200 / 20";

        boolean isValid1 = validation.validate(exp1);
        boolean isValid2 = validation.validate(exp2);

        assertThat(isValid1).isTrue();
        assertThat(isValid2).isTrue();
    }

    @Test
    void 틀린_수식_테스트() {
        String exp1 = "1 + 2 + 3 = ";
        String exp2 = "+2+ 3";
        String exp3 = "121 a fd";

        boolean isValid1 = validation.validate(exp1);
        boolean isValid2 = validation.validate(exp2);
        boolean isValid3 = validation.validate(exp3);

        assertThat(isValid1).isFalse();
        assertThat(isValid2).isFalse();
        assertThat(isValid3).isFalse();
    }
}