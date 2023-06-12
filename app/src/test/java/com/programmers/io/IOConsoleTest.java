package com.programmers.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOConsoleTest {
    private static final String HISTORY_OPTION_MESSAGE = "1. 조회";
    private static final String CALCULATE_OPTION_MESSAGE = "2. 계산";

    private static IOConsole ioConsole;
    private static OutputStream out;

    @BeforeEach
    void initAll() {
        ioConsole = new IOConsole(); // 입출력 콘솔

        // 표준 출력 설정
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void printMenuTest() {
        ioConsole.printMenu();

        assertEquals(HISTORY_OPTION_MESSAGE + "\n" + CALCULATE_OPTION_MESSAGE + "\n\n", out.toString());
    }

    @Test
    void printAnswerTest() {
        double answer = 3.141592;

        ioConsole.printAnswer(answer);

        assertEquals("3.14\n\n", out.toString());
    }

    @Test
    void validateInputExpressionTest() {
        String expression1 = "1 +2";
        String expression2 = "1 * 2";
        String expression3 = "1 $2";
        String expression4 = " 12 - 1";
        String expression5 = "1 &2";
        String expression6 = "1 /2";

        boolean result1 = ioConsole.validateInputExpression(expression1);
        boolean result2 = ioConsole.validateInputExpression(expression2);
        boolean result3 = ioConsole.validateInputExpression(expression3);
        boolean result4 = ioConsole.validateInputExpression(expression4);
        boolean result5 = ioConsole.validateInputExpression(expression5);
        boolean result6 = ioConsole.validateInputExpression(expression6);

        assertEquals(true, result1);
        assertEquals(true, result2);
        assertEquals(false, result3);
        assertEquals(true, result4);
        assertEquals(false, result5);
        assertEquals(true, result6);
    }
}
