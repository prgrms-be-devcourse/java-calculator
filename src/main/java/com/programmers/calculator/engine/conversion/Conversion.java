package com.programmers.calculator.engine.conversion;

import java.util.List;

public interface Conversion {
    List<String> splitFormula(String formula);

    List<String> infixToPostfix(List<String> tokens);

    List<String> formulaToPostfixTokens(String formula);
}
