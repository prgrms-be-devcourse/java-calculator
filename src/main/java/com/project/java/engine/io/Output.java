package com.project.java.engine.io;

import java.util.List;

public interface Output {
    void printResult(String str);
    void printMenu();
    void inputError();
    void messageEmpty();
    void printHistory(List<String> historyList);
}
