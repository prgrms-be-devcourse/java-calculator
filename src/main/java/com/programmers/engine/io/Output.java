package com.programmers.engine.io;

import java.util.List;

public interface Output {
    void printStart();

    void printResult(Integer calculate);

    void printHistory(List<List<String>> history);
}
