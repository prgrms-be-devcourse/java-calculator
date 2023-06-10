package org.calculator.engine.io;

import org.calculator.engine.error.ErrorCode;

public interface Output {
    void printAnswer(int answer);

    void printError(ErrorCode errorCode);
}
