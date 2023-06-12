package org.programmers.java.calculation;

import java.util.*;

public class Calculation {

    private final InfixToPostfixConverter infixToPostfixConverter;
    private final PostfixCalculation postfixCalculation;

    public Calculation(InfixToPostfixConverter infixToPostfixConverter, PostfixCalculation postfixCalculation) {
        this.infixToPostfixConverter = infixToPostfixConverter;
        this.postfixCalculation = postfixCalculation;
    }

    public String requestCalculate(String inputFormula){
        String[] formulaList = inputFormula.split(" ");
        List<String> postfixOperator = infixToPostfixConverter.convert(formulaList);
        String result = postfixCalculation.calculate(postfixOperator);
        return result;
    }
}
