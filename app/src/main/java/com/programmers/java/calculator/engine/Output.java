package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.model.Problem;

import java.util.List;

public interface Output {
    void inputError();
    void showAllProblemNAnswer(List<Problem> problemList);
    void showAnswer(Problem problem);
}
