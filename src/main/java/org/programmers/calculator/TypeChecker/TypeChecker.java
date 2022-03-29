package org.programmers.calculator.TypeChecker;

import org.programmers.calculator.configuration.Component;

import java.util.Map;

@Component
public interface TypeChecker {

    boolean isOperand(String value);
    boolean isOperator(String value);

    Map<String, Integer> getOperatorRank();
}
