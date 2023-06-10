package com.programmers.validator;

import com.programmers.exception.EquationFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "()"
            , "(())"
            , "()()(("
            , "))(("
    })
    void 괄호테스트(String bracket) {

        assertThatThrownBy(() -> InputValidator.containsBracket(bracket))
                .isInstanceOf(EquationFormatException.class);
    }

    @Test
    void test() {
        InputValidator.checkBracket("()()123");
    }
}