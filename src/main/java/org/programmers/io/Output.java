package org.programmers.io;

import org.programmers.domain.expression.ExpressionResult;

import java.util.Map;

public interface Output {

    void printConsole();

    void printAnswer(double answer);

    void printError();

    void printHistory(Map<Long, ExpressionResult> history);
}
