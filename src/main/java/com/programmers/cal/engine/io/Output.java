package com.programmers.cal.engine.io;

import java.util.List;

public interface Output {
    void requestInput();

    void printWrongOrder();

    void printRecord(List<String> recordList);

    void printResult(String result);

    void printExit();

    void printZeroDivision();

    void printNoRecord();
}
