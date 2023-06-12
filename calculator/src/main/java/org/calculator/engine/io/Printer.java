package org.calculator.engine.io;

import org.calculator.engine.error.ErrorCode;

import java.util.Optional;

public interface Printer {
    Optional<String> printCondition();

    String insertEquation();

    void printAnswer(int answer);

    void printError(ErrorCode errorCode);
}
