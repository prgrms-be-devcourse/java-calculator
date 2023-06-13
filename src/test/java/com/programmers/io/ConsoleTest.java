package com.programmers.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    private static final String MENU_MESSAGE = "1. 조회\n2. 계산\n3. 종료\n";
    private static final String MENU_SELECTION_MESSAGE = "선택 : ";

    Console console = new Console();

    @Test
    void 메뉴를_출력한다() {
        //given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        console.printMenu();

        //then
        assertThat(outputStream.toString()).contains(MENU_MESSAGE);
        assertThat(outputStream.toString()).contains(MENU_SELECTION_MESSAGE);
    }
}