package com.programmers.kwonjoosung.java.calculator.io;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputTest {
    static Console output;

    @BeforeAll
    @DisplayName("출력")
    static void startOutput() {
        output = new Console();
    }

    static ByteArrayOutputStream outputStream;
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void reset() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("출력 테스트")
    void printlnTest() {
        // given
        String result = "출력";
        // when
        output.println(result);
        // then
        assertEquals(result, outputStream.toString().trim());
    }

    @Test
    @DisplayName("메뉴 출력 테스트")
    void printMenuTest() {
        // given
        String result = "1. 조회\r\n2. 계산";
        // when
        output.printMenu();
        // then
        assertEquals(result, outputStream.toString().trim());
    }

    @Test
    @DisplayName("종료 출력 테스트")
    void printExitTest() {
        // given
        String result = "프로그램을 종료합니다.";
        //when
        output.printExit();
        // then
        assertEquals(result, outputStream.toString().trim());
    }

    @Test
    @DisplayName("에러 출력 테스트")
    void printError() {
        // given
        String result = "오류 발생!\r\n오류";
        // when
        output.printError("오류");
        // then
        assertEquals(result, outputStream.toString().trim());
    }

    @Test
    @DisplayName("메뉴 에러 출력 테스트")
    void printMenuError() {
        // given
        String result = "1 ~ 2번 메뉴 중 하나를 선택해주세요(종료는 99)";
        // when
        output.printMenuError();
        // then
        assertEquals(result, outputStream.toString().trim());
    }

    @Test
    @DisplayName("조회 값 없음 출력 테스트")
    void printNullError() {
        // given
        String result = "조회할 데이터가 없습니다.";
        // when
        output.printNullError();
        // then
        assertEquals(result, outputStream.toString().trim());
    }
}
