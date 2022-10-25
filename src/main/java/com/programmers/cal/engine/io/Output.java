package com.programmers.cal.engine.io;

public interface Output {
    void requestInput();

    void printWrongOrder();

    void printRecord();

    void printResult(String result);

    void printExit();

    void printZeroDivision();
}
