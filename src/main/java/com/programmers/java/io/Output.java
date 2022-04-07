package com.programmers.java.io;

import com.programmers.java.entity.Calculation;

import java.util.List;


public interface Output {

    void printMenu();

    void printHistory(List<Calculation> history);

    void printMenuError();

    void printResult(int result);

    void printFormulaError(String message);
}
