package com.project.java;

import com.project.java.engine.Calculator;
import com.project.java.engine.io.Console;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Console console = new Console();

        new Calculator(0, console, console).run();
    }
}