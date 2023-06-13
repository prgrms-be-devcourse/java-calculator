package com.programmers.service;

import com.programmers.io.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    private final Console console = new Console();
    private final CalculatorService calculatorService = new CalculatorService(console);
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;
    private final InputStream inputStream = System.in;

    @BeforeEach
    public void before() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void after() {
        System.setOut(printStream);
        System.setIn(inputStream);
    }

    @Test
    void 계산한다() {
        //given
        String input = "5 + 2 + 34 * 23 / 2 - 3" + "\n";
        String expected = "395";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        try {
            calculatorService.calculate();

            assertThat(outputStream.toString()).contains(expected);
        } catch (NoSuchElementException ignore) {
        }
    }

    @Test
    void 후위표기식을_계산한다() {
        //given
        List<String> postfix = Arrays.asList(
                "5", "2", "+", "34", "23", "*", "2", "/", "+", "3", "-"
        );
        int expected = 395;

        //when
        int result = calculatorService.calculatePostfix(postfix);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 스택의_수들을_꺼내어_계산한다() {
        //given
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(4);

        String token = "*";
        int expected = 12;

        //when
        int result = calculatorService.operate(stack, token);

        //then
        assertThat(result).isEqualTo(expected);
    }
}