package org.programmers.java.calculator.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    Console console = new Console();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    @DisplayName("입력을 받았을때 값이 정확한지 검증하라")
    void read(String input) {
        //given

        //when

        //then
    }

    @Test
    void print() {
        //given

        //when

        //then
    }

    @Test
    void printMeun() {
        //given

        //when

        //then
    }

    @Test
    void printError() {
        //given

        //when

        //then
    }
}