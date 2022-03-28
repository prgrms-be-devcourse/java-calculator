package com.calculator.java;

import com.calculator.java.engine.comand.CommandTypes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {
    Validation validation = new Validation(CommandTypes.values());

    @ParameterizedTest
    @ValueSource(strings = {"q", "qwerasdfzxcv", "qq23"})
    void 틀린_명령_선택_테스트(String selectedCommand) {
        boolean isValid = validation.validateSelectedCommand(selectedCommand);
        assertThat(isValid).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + 3", "3 - -2 + 3 * 200 / 20"})
    void 정상_수식_테스트(String exp) {
        boolean isValid = validation.validateMathExpression(exp);
        assertThat(isValid).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + 3 = ", "+2+ 3", "121 a fd", "1  + 2", "1"})
    void 틀린_수식_테스트(String exp) {
        boolean isValid = validation.validateMathExpression(exp);
        assertThat(isValid).isFalse();
    }
}