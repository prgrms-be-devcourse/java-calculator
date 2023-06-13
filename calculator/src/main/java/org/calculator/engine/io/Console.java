package org.calculator.engine.io;

import org.calculator.engine.domain.Condition;

public interface Console {
    Condition getCondition();

    String insertEquation();

    void printAnswer(double answer);

    void printHistory();
}
