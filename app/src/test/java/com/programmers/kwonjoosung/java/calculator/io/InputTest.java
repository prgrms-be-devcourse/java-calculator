package com.programmers.kwonjoosung.java.calculator.io;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {
    static Console input;

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeAll
    @DisplayName("입력")
    static void startInput() {
        input = new Console();
    }

    @Test
    @DisplayName("메뉴 입력 테스트")
    void inputMenuTest() {
        // given
        InputStream in = generateUserInput("2\n");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        input.setScanner(scanner);
        int menu;
        // when
        menu = input.inputMenu();
        //then
        assertEquals(2, menu);
    }

    @Test
    @DisplayName("식 입력 테스트")
    void inputExpressionTest() {
        //given
        InputStream in = generateUserInput("1 + 1\n");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        input.setScanner(scanner);
        //when
        String expression = input.inputExpression();
        //then
        assertEquals("1 + 1", expression);
    }
}
