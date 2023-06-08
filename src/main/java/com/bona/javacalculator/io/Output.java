package com.bona.javacalculator.io;

import com.bona.javacalculator.model.InputAndAnswer;

import java.util.List;

public interface Output {
    void outAnswer(Double answer);

    void printAll(List<InputAndAnswer> inputAndAnswerList);

    void printMessage(String message);
}
