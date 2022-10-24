package com.project.java.engine.io;

import java.util.List;

public interface Output {
    String printResult(Double result);
    void printMenu();
    void inputError();
    void messageEmpty();
    void printHistory(List<String> historyList);
}
