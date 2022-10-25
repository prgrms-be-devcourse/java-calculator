package com.programmers.java.engine.io;

import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Equation;

import java.util.List;

public interface Output {
    void inputError();

    void printAnswer(Answer answer);

    void printHistory(List<Equation> history);
}
