package com.wonu606.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleInputTest {

    @Test
    @DisplayName("메뉴 입력")
    void testMenuSelectionInput() {
        String menuSelection = "1";
        InputStream in = new ByteArrayInputStream(menuSelection.getBytes());
        System.setIn(in);

        Input input = new ConsoleInput();
        assertThat(menuSelection).isEqualTo(input.getInput());
        input.tearDown();
    }

    @Test
    @DisplayName("표현식 입력")
    void testExpressionInput() {
        String expression = "2 + 3";
        InputStream in = new ByteArrayInputStream(expression.getBytes());
        System.setIn(in);

        Input input = new ConsoleInput();
        assertThat(expression).isEqualTo(input.getInput());
        input.tearDown();
    }

    @Test
    @DisplayName("개행 입력")
    void testNewLineInput() {
        String newLine = "\n";
        InputStream in = new ByteArrayInputStream(newLine.getBytes());
        System.setIn(in);

        Input input = new ConsoleInput();
        assertThat("").isEqualTo(input.getInput());
        input.tearDown();
    }
}
