package com.programmers.calculator.engine.conversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ConversionFormula implements Conversion {
    private final String NUMBER = "^[0-9]*$";

    @Override
    public List<String> splitFormula(String formula) {
        List<String> tokenList = new ArrayList<>(Arrays.asList(formula.split(" ")));
        return tokenList;
    }

    @Override
    public List<String> infixToPostfix(List<String> tokenList) {
        List<String> postfix = new ArrayList<>();
        Stack<String> symbolStack = new Stack<>();

        for (String token : tokenList) {
            if (token.matches(NUMBER)) {
                postfix.add(token);
                continue;
            }

            if (token.equals("(")) {
                symbolStack.add(token);
                continue;
            }

            if (token.equals(")")) {
                while (!symbolStack.peek().equals("(")) {
                    postfix.add(symbolStack.pop());
                }
                symbolStack.pop();
                continue;
            }

            while (!symbolStack.isEmpty() && priorityCheck(symbolStack.peek(), token)) {
                postfix.add(symbolStack.pop());
            }
            symbolStack.add(token);
        }
        while (!symbolStack.isEmpty()) {
            postfix.add(symbolStack.pop());
        }

        return postfix;
    }

    private int priority(String symbol) {
        switch (symbol) {
            case "(":
                return 0;

            case "+":
            case "-":
                return 1;

            default:
                return 2;
        }
    }

    private boolean priorityCheck(String peekSymbol, String tempSymbol) {
        return priority(peekSymbol) >= priority(tempSymbol);
    }

    //이렇게 사용해도 되는지 궁금합니다.
    @Override
    public List<String> formulaToPostfixTokens(String formula) {
        List<String> formulaToken = splitFormula(formula);
        return infixToPostfix(formulaToken);
    }

}
