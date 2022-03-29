package org.programmers.calculator.TypeChecker;

import java.util.Map;

public interface TypeChecker {

    boolean isOperand(String value);
    boolean isOperator(String value);

    Map<String, Integer> getOperatorRank();
}
