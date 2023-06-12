package com.devcourse.java.calculator.io;

import java.util.LinkedHashMap;

public interface Output {

    void printCommandMenu();
    void printCalculateHistory(LinkedHashMap<Integer, String> calculateHistory);
    void printExceptionMessage(String message);
    void printRequestEquationInput();
    void printAnswerFromEquation(String answer);
}
