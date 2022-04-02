package com.programmers.java.calculator.io;

import java.util.List;

public interface Output {
    void printInputError();
    void printMenu();
    void logs(List<String> log);
    void print(String content);
}