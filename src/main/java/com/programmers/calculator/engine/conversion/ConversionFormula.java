package com.programmers.calculator.engine.conversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ConversionFormula implements Conversion {
    private final String NUMBER = "^[0-9]*$";

    @Override
    public List<String> splitFormula(String formula) {
        return new ArrayList<>(Arrays.asList(formula.split(" ")));
    }

    @Override
    public List<String> infixToPostfix(List<String> tokenList) {
        List<String> postfix = new ArrayList<>();
        Stack<String> symbolStack = new Stack<>();

        for (String token : tokenList) {
            divisionTokens(postfix, symbolStack, token);
        }

        while (!symbolStack.isEmpty()) {
            postfix.add(symbolStack.pop());
        }

        return postfix;
    }

    private void divisionTokens(List<String> postfix, Stack<String> symbolStack, String token) {
        if (token.matches(NUMBER)) {
            postfix.add(token);
            return;
        }

        if (token.equals("(")) {
            symbolStack.add(token);
            return;
        }

        if (token.equals(")")) {
            while (!symbolStack.peek().equals("(")) {
                postfix.add(symbolStack.pop());
            }
            symbolStack.pop();
            return;
        }
        if (token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")){
            while (!symbolStack.isEmpty() && isHighPriority(symbolStack.peek(), token)) {
                postfix.add(symbolStack.pop());
            }
            symbolStack.add(token);
        }
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

    private boolean isHighPriority(String peekSymbol, String tempSymbol) {
        return priority(peekSymbol) >= priority(tempSymbol);
    }

    @Override
    public List<String> formulaToPostfixTokens(String formula) {
        List<String> formulaToken = splitFormula(formula);
        return infixToPostfix(formulaToken);
    }

}
