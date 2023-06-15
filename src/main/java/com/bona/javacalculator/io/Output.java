package com.bona.javacalculator.io;

import com.bona.javacalculator.model.ExpressionResult;

import java.util.List;

public interface Output {
    void outAnswer(Double answer);

    void printAll(List<ExpressionResult> expressionResultList);

    void printMessage(String message);
}
