package com.programmers.io;

import java.util.List;

public interface Output {
    void printResult(int result);

    void printResult(List<String> findCalculations);

    void exit();

    void inputError();

    void printError(RuntimeException ex);
}
