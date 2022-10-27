package com.programmers.java.engine.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleIOController extends IOController {
    private final Scanner scanner;
    private final PrintStream printer;

    public ConsoleIOController(InputStream reader, OutputStream writer) {
        super(reader, writer);
        this.scanner = new Scanner(reader);
        this.printer = new PrintStream(writer);
    }

    public String read() {
        return scanner.nextLine();
    }

    public void print(Object message) {
        printer.print(message.toString());
    }
}
