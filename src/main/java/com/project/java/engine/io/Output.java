package com.project.java.engine.io;

import com.project.java.engine.data.ResultFormat;

import java.util.List;

public interface Output {
    void printResult(ResultFormat result);
    void printMenu();
    void inputError();
    void messageEmpty();
    void printHistory(List<String> historyList);
}
