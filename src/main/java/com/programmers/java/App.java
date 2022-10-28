package com.programmers.java;

import com.programmers.java.engin.Calculator;
import com.programmers.java.engin.io.Calculation;
import com.programmers.java.engin.PostfixCalculation;

public class App {
    public static void main(String[] args) {

        Calculation calculation = new PostfixCalculation();
        Console console = new Console();
        new Calculator(calculation,console,console).run();
    }
}
