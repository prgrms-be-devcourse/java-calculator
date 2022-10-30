package com.programmers.controller;

import com.programmers.domain.CalculatorResult;
import com.programmers.domain.Result;
import com.programmers.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class StringCalculatorTest {

    /*
    @CsvSource(value = {
            "2:10 - 100 * 2:10 - 100 * 2 = -190",
            "2:20 - 10 * 5:20 - 10 * 5 =-30",
            "2:100 * 100 / 20:100 * 100 / 20 = 500",
            "2:1000 + 2000 + 3000 - 1000 * 3:1000 + 2000 + 3000 - 1000 * 3 = 500",
            "3:10 + 10:20"}, delimiter = ':')

     */


    @ParameterizedTest
    @MethodSource("testInputString")
    void play(String selectNum, String inputString, int answer) throws IOException {
        System.in.close();
        CalculatorResult calculatorResult = new CalculatorResult();
        StringCalculator stringCalculator = new StringCalculator(calculatorResult);

        List<InputStream> streams = Arrays.asList(
                generateUserInput(selectNum + "\n"),
                generateUserInput(inputString + "\n"), generateUserInput("3")
        );

        InputStream inputStream = new SequenceInputStream(Collections.enumeration(streams));
        System.setIn(inputStream);
        stringCalculator.play();

        int result = calculatorResult.getResult().get(inputString);
        assertEquals(result, answer);


    }

    @Test
    void 출력Test() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.out.println("안녕하세요");
        assertEquals("안녕하세요", out.toString().trim());
    }

    @Test
    void 입력Test2() {
        InputStream input = new ByteArrayInputStream("3 + 3".getBytes());
        System.setIn(input);
        String result = InputView.inputString();
        assertEquals(result, "3 + 3");
    }

    @Test
    void 입력Test1() {
        InputStream input = new ByteArrayInputStream("3".getBytes());
        System.setIn(input);
        int result = InputView.selectMenu();
        assertEquals(result, 3);
    }

    @Test
    void 입력Test3() {
        InputStream input = createInputStream("2\n", "1 +    1\n", "3");
        System.setIn(input);
        String result = inputDouble();

        assertEquals(result, "2, 1 + 1");
    }

    private InputStream createInputStream(String selectNum, String inputString, String terminal) {
        List<InputStream> streams = Arrays.asList(generateUserInput(selectNum),
                generateUserInput(inputString),
                generateUserInput(terminal));
        return new SequenceInputStream(Collections.enumeration(streams));
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    String inputDouble() {
        int num = InputView.selectMenu();
        String result = InputView.inputString();
        return num + ", " + result;
    }


    static Stream<Arguments> testInputString() {
        return Stream.of(
                arguments("2", "10 - 100 * 2", -190),
                arguments("2", "20 - 10 * 5", -30),
                arguments("2", "100 * 100 / 20", 500),
                arguments("2", "1000 + 2000 + 3000 - 1000 * 3", 3000),
                arguments("3", "10 + 10", 20));
    }
}