package com.programmers.java.calculator.io;

import java.util.List;

public interface Output {
    void inputError();
    void menu();
    void logs(List<String> log);
    void print(String content);
}