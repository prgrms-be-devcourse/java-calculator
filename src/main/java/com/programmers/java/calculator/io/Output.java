package com.programmers.java.calculator.io;

import java.util.List;

public interface Output {
    void printInputError();
    void printMenu();
    void printLogs(List<String> log);
    void print(String content);
    void printCloseConsole();
}