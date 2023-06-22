package com.programmers.java.calculator.engine.io;

public interface Output {

    void printMenu();
    void printError(String msg);
    void printExceptionMsg(String msg);
    void printMsg(String msg);
    void printAnswer(double answer);
}
