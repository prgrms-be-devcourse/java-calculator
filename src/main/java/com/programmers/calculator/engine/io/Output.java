package com.programmers.calculator.engine.io;

import java.util.List;

public interface Output {
    void printResult(int result);
    void inputError();
    void printEnter();
    void printRepository(List<String> data);
    void emptyError();
}
