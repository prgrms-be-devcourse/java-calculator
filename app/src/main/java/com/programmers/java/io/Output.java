package com.programmers.java.io;

import com.programmers.java.model.History;

import java.util.List;

public interface Output {
    void printMenu(String menu);

    void printHistory(List<History> history);

    void printFormulaResult(Integer result);

    void printErrorMessage(String errorMessage);
}
