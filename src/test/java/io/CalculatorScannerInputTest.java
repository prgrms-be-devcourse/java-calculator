package io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static io.CalculatorScannerInput.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorScannerInputTest {

    @Test
    @DisplayName("1 또는 2을 입력하지 않는 경우 테스트")
    void inputButton() {
        String input = "3";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        CalculatorInput calculatorScannerInput = new CalculatorScannerInput();

        assertThatThrownBy(calculatorScannerInput::inputButton)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT_BUTTON);
    }

    @Test
    @DisplayName("양식에 맞지 않는 수식을 입력할 경우 테스트")
    void inputExpression() {
        String input = "1 + 2 + a";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        CalculatorInput calculatorScannerInput = new CalculatorScannerInput();

        assertThatThrownBy(calculatorScannerInput::inputExpression)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_EXPRESSION);
    }
}