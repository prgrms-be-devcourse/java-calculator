package com.programmers.cal.engine.io;

import com.programmers.cal.engine.model.Answer;
import com.programmers.cal.engine.model.Record;

public interface Output {
    void requestInput();

    void printWrongOrder();

    void printRecord(Record record);

    void printResult(Answer answer);

    void printExit(Message exitMessage);

    void printZeroDivision();

    void printNoRecord();
}
