package com.devcourse;

import com.devcourse.calc.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        while (true) {
            calculator.run();
        }
    }
}