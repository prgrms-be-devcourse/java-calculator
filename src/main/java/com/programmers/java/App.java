package com.programmers.java;

import com.programmers.java.engin.Calculator;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Console console = new Console();
        new Calculator(console,console).run();
    }
}
