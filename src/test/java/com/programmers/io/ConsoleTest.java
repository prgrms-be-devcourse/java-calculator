package com.programmers.io;

import com.programmers.exception.EquationFormatException;
import com.programmers.validator.InputValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "5+",
            "2)"
    })
    void 입력식_연산자_예외(String equation) {
        assertThatThrownBy(() -> InputValidator.checkEquation(equation))
                .isInstanceOf(EquationFormatException.class);
    }

}