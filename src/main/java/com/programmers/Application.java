package com.programmers;


import com.programmers.domain.Calculator;
import com.programmers.io.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}