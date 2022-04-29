package com.calculator.java.console;

import com.calculator.java.console.Validator;
import com.calculator.java.global.Enum.CommandTypes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    Validator validator = new Validator(CommandTypes.values());

    @ParameterizedTest
    @ValueSource(strings = {"q", "qwerasdfzxcv", "qq23"})
    void 틀린_명령_선택_테스트(String selectedCommand) {
        boolean isValid = validator.validateSelectedCommand(selectedCommand);
        assertThat(isValid).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + 3", "3 - -2 + 3 * 200 / 20", "0.1 + 1", "1 * 2.123"})
    void 정상_수식_테스트(String exp) {
        boolean isValid = validator.validateMathExpression(exp);
        assertThat(isValid).isTrue();
    }



    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + 3 = ", "+2+ 3", "121 a fd", "1  + 2", "1"})
    void 틀린_수식_테스트(String exp) {
        boolean isValid = validator.validateMathExpression(exp);
        assertThat(isValid).isFalse();
    }
}