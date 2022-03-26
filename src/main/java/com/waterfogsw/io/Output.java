package com.waterfogsw.io;

import com.waterfogsw.domain.Calculation;

import java.util.List;

public interface Output {
    void printResult(String expr, String result);

    void printHistories(List<Calculation> calculations);

    void inputError();

    void divZeroError();
}
