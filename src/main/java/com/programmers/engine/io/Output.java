package com.programmers.engine.io;

import java.util.Map;

public interface Output {
    void showMenu();
    void inputError();
    void readAllResults(Map<Integer, String> map);
    void printAnswer(int answer);
}
