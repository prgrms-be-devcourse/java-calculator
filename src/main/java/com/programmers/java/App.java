package com.programmers.java;

import com.programmers.java.engin.Calculator;
import com.programmers.java.engin.io.Calculation;
import com.programmers.java.engin.postfixCalculation;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Calculation calculation = new postfixCalculation();
        Console console = new Console();
        new Calculator(calculation,console,console).run();
    }
}
