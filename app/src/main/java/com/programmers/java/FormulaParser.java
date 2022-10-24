package com.programmers.java;

import java.util.*;

public class FormulaParser {
    public String[] changeInfixToPostfix(String formula) {
        Stack<String> formulaCharStack = new Stack<>();
        HashSet<String> operatorSet = new HashSet<>(Arrays.asList("+", "-", "/", "*"));
        String[] formulaSplit = formula.split("((?=[-+/*()])|(?<=[-+/*()]))");

        List<String> postfixFormula = new ArrayList<>();

        for (int i = 0; i < formulaSplit.length; i++) {
            if (operatorSet.contains(formulaSplit[i])) {
                while (!formulaCharStack.isEmpty() && getPriority(formulaCharStack.peek()) >= getPriority(formulaSplit[i])) {
                    postfixFormula.add(formulaCharStack.pop());
                }

                formulaCharStack.push(formulaSplit[i]);
            } else if (formulaSplit[i].equals("(")) {
                formulaCharStack.push(formulaSplit[i]);
            } else if (formulaSplit[i].equals(")")) {
                while (!formulaCharStack.isEmpty() && !formulaCharStack.peek().equals("(")) {
                    postfixFormula.add(formulaCharStack.pop());
                }

                formulaCharStack.pop();
            } else {
                postfixFormula.add(formulaSplit[i]);
            }
        }

        while (!formulaCharStack.isEmpty()) {
            postfixFormula.add(formulaCharStack.pop());
        }

        return postfixFormula.toArray(String[]::new);
    }

    public int getPriority(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("(") || operator.equals(")")) {
            return 0;
        }

        return -1;
    }
}
