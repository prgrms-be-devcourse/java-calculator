package io;

import caculator.exception.WrongCalculatorMenuChoiceException;
import caculator.exception.WrongFormulaException;
import caculator.io.CalculatorIO;
import caculator.io.IO;
import caculator.io.Input;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorIOTest {
    CalculatorIO calculatorIO;

    void initialize(String testInput) {
        InputStream is = new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8));
        calculatorIO = new CalculatorIO(is);
    }

    @Test
    void testGetNum() throws WrongCalculatorMenuChoiceException {
        initialize("3/n");
        assertThrows(WrongCalculatorMenuChoiceException.class, () -> calculatorIO.getNum());

        initialize("hello/n");
        assertThrows(WrongCalculatorMenuChoiceException.class, () -> calculatorIO.getNum());
    }

    @Test
    void testGetLineWithNoSpaces() throws WrongFormulaException {
        String expectedOutput = "32+213+213";

        initialize("  32 + 213+ 213   \n");
        assertTrue(expectedOutput.equals(calculatorIO.getLineWithNoSpaces().toString()));
    }
}