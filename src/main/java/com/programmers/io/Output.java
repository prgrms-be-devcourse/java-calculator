package com.programmers.io;

import com.programmers.domain.model.Calculation;

import java.util.List;

public interface Output {
    void printResult(int result);

    void printResult(List<Calculation> findCalculations);

    void exit();

    void inputError();

    void printError(RuntimeException ex);
}
