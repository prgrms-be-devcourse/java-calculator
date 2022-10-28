package com.programmers.cal.engine.io;

import com.programmers.cal.engine.model.Answer;
import com.programmers.cal.engine.model.Record;

import java.util.List;

public interface Output {
    void requestInput();

    void printWrongOrder();

    void printRecord(Record record);

    void printResult(Answer answer);

    void printExit();

    void printZeroDivision();

    void printNoRecord();
}
