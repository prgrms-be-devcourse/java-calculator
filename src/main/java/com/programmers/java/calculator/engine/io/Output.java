package com.programmers.java.calculator.engine.io;

public interface Output {
    void print(String s);

    void printError(String s);

    void printResult(Integer result);
}
