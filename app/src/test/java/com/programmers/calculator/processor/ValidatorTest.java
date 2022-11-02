package com.programmers.calculator.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("띄어쓰기가 올바르지 않은 경우 예외가 발생한다.")
    void isRightSpacing() {
        // given
        String inputStr = "1+1";
        String[] parsedInputStr = calculator.parseFolmula(inputStr);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> Validator.isRightSpacing(parsedInputStr));
    }


    @DisplayName("연산자가 아니거나 숫자가 잘못된 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "1+1 * 1",
            "1 @ 3 + 1",
            "1 + 3 * ~",
            "1 ) 3 * 4",
            "3.1 ( 4.2 + 5.3"
    })
    void isRightOperatorAndNumbers(String formula) {
        // when, then
        assertThrows(IllegalArgumentException.class, () -> Validator.isRightOperatorAndNumbers(calculator.parseFolmula(formula)));
    }
}