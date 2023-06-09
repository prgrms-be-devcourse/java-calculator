package com.wonu606.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsolePrinterTest {

    @Test
    @DisplayName("정수 출력")
    void testIntegerPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Print printer = new ConsolePrinter();
        int number = -1;
        printer.print(number);

        assertThat(Integer.toString(number)).isEqualTo(out.toString().trim());
    }

    @Test
    @DisplayName("문자열 출력")
    void testStringPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Print printer = new ConsolePrinter();
        String str = "Hello World";
        printer.print(str);

        assertThat(str).isEqualTo(out.toString().trim());
    }
}
