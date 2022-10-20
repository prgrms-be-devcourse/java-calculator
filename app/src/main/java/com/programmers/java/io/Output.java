package com.programmers.java.io;

import java.util.List;

public interface Output {
    void printMenu(String menu);

    void printHistory(List<String> history);

    void printFormulaResult(Integer result);

    void printErrorMessage(String errorMessage);
}
