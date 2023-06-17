package com.programmers.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.programmers.controller.CalculatorController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

class CalculatorControllerTest {

    private final CalculatorController calculatorController = new CalculatorController();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final InputStream inputStream = System.in;
    private final PrintStream printStream = System.out;

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
    public void 계산한다() {
        String[] inputs = { "2", "1 + 9 * 5", "2", "4 / 6 - 3", "2", "4 * 2 + 6", "2", "2 * 9 - 5", "3" };
        System.setIn(new ByteArrayInputStream(String.join("\n", inputs).getBytes()));

        try {
            calculatorController.run();
            String output = outputStream.toString();

            assertTrue(output.contains("1. 조회"));
            assertTrue(output.contains("2. 계산"));
            assertTrue(output.contains("3. 종료"));
            assertTrue(output.contains("선택 : "));

            assertTrue(output.contains("46"));
            assertTrue(output.contains("-3"));
            assertTrue(output.contains("14"));
            assertTrue(output.contains("13"));
        } catch (NoSuchElementException ignore) {
        }
    }

    @Test
    public void 조회한다() {
        String[] inputs = { "2", "1 + 9 * 5", "1", "3" };
        System.setIn(new ByteArrayInputStream(String.join("\n", inputs).getBytes()));

        try {
            calculatorController.run();
            String output = outputStream.toString();

            assertTrue(output.contains("1. 조회"));
            assertTrue(output.contains("2. 계산"));
            assertTrue(output.contains("3. 종료"));
            assertTrue(output.contains("선택 : "));

            assertTrue(output.contains("1 + 9 * 5 = 46"));

        } catch (NoSuchElementException ignore) {
        }
    }

    @Test
    public void 종료한다() {
        String[] inputs = { "3" };
        System.setIn(new ByteArrayInputStream(String.join("\n", inputs).getBytes()));

        try {
            calculatorController.run();
            String output = outputStream.toString();

            assertTrue(output.contains("1. 조회"));
            assertTrue(output.contains("2. 계산"));
            assertTrue(output.contains("3. 종료"));
            assertTrue(output.contains("선택 : "));
            assertTrue(output.contains("계산기 프로그램을 종료합니다."));

        } catch (NoSuchElementException ignore) {
        }
    }
}