package com.programmers.calculator.io;

import java.util.List;

public interface Output {
    void printMenu(List<String> menu);

    void printResult(int result);
}
