package org.programmers.java.calculation;

import java.util.*;

public class Calculation {
    private final InfixToPostfixConverter infixToPostfixConverter;
    private final PostfixCalculation postfixCalculation;

    public Calculation() {
        this.infixToPostfixConverter = new InfixToPostfixConverter();
        this.postfixCalculation = new PostfixCalculation();
    }

    public String requestCalculate(String inputFormula){
        String[] formulaList = inputFormula.split(" ");
        List<String> postfixOperator = infixToPostfixConverter.convert(formulaList);
        String result = postfixCalculation.calculate(postfixOperator);
        return result;
    }
}
