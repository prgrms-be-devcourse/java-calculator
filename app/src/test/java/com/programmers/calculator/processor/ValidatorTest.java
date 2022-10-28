package com.programmers.calculator.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("연산자가 아니거나 숫자가 잘못된 경우 예외가 발생한다.")
    void isRightOperatorAndNumbers() {
        // given
        String[] inputFormula = new String[] {
                "1+1 * 1",
                "1 @ 3 + 1",
                "1 + 3 * ~",
                "1 ) 3 * 4",
                "3.1 ( 4.2 + 5.3"
        };

        String[][] parsedInputFormula = new String[inputFormula.length][];
        for (int i = 0; i < 5; i++) {
            parsedInputFormula[i] = calculator.parseFolmula(inputFormula[i]);
        }

        // when, then
        assertThrows(IllegalArgumentException.class, () -> Validator.isRightOperatorAndNumbers(parsedInputFormula[0]));
        assertThrows(IllegalArgumentException.class, () -> Validator.isRightOperatorAndNumbers(parsedInputFormula[1]));
        assertThrows(IllegalArgumentException.class, () -> Validator.isRightOperatorAndNumbers(parsedInputFormula[2]));
        assertThrows(IllegalArgumentException.class, () -> Validator.isRightOperatorAndNumbers(parsedInputFormula[3]));
        assertThrows(IllegalArgumentException.class, () -> Validator.isRightOperatorAndNumbers(parsedInputFormula[4]));
    }
}