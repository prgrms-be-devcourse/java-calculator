package com.programmers.io;

import com.programmers.domain.Calculator;

import java.util.List;

public interface Output {
    void printResult(int result);

    void printResult(List<Calculator> findCalculations);

    void exit();

    void inputError();

    void printError(RuntimeException ex);
}
