package com.programmers.java.engine.io;

import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.EquationRecord;

public interface Output {
    void inputError();

    void printAnswer(Answer answer);

    void printHistory(EquationRecord record);
}
