package com.programmers.java.engine.io;

import com.programmers.java.engine.model.Answer;

public interface Output {
    void inputError();

    void printAnswer(Answer answer);

    void printHistory(String inputHistory);
}
