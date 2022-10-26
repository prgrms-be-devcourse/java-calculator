package com.programmers.kwonjoosung.java.calculator.io;

public interface Output {
    void println(String message);

    void printMenu();

    void printExit();

    void printMenuError();

    void printNullError();

    void printError(String message);
}
