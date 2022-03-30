package com.programmers.java.calculator.engine.io;

public interface Output {
    void print(String s);

    void printCalculatorException(String s);

    void printInputException(String s);

    void printResult(Integer result);
}
