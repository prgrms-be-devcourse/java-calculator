package com.programmers.java.engine.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleIOController extends IOController {
    private final Scanner scanner;

    public ConsoleIOController(InputStream reader, OutputStream writer) {
        super(reader, writer);
        this.scanner = new Scanner(reader);
    }

    public String read() {
        return scanner.nextLine();
    }

    public void print(Object message) {
        new PrintStream(writer).print(message.toString());
    }
}
