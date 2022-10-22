package com.programmers.java;

import java.util.*;

public class FormulaParser {
    public String[] changeInfixToPostfix(String formula) {
        Stack<String> formulaCharStack = new Stack<>();
        HashSet<String> operatorSet = new HashSet<>(Arrays.asList("+", "-", "/", "*"));
        List<String> formulaSplit = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < formula.length(); i++) {
            sb.append(formula.charAt(i));

            if (!Character.isDigit(formula.charAt(i))) {
                formulaSplit.add(sb.toString());
                sb.setLength(0);
                continue;
            }
            if ((i + 1) != formula.length() && !Character.isDigit(formula.charAt(i + 1))) {
                formulaSplit.add(sb.toString());
                sb.setLength(0);
            }
            if ((i + 1) == formula.length()) {
                formulaSplit.add(sb.toString());
            }
        }

        List<String> postfixFormula = new ArrayList<>();

        for (int i = 0; i < formulaSplit.size(); i++) {
            if (operatorSet.contains(formulaSplit.get(i))) {
                while (!formulaCharStack.isEmpty() && getPriority(formulaCharStack.peek()) >= getPriority(formulaSplit.get(i))) {
                    postfixFormula.add(formulaCharStack.pop());
                }

                formulaCharStack.push(formulaSplit.get(i));
            } else if (formulaSplit.get(i).equals("(")) {
                formulaCharStack.push(formulaSplit.get(i));
            } else if (formulaSplit.get(i).equals(")")) {
                while (!formulaCharStack.isEmpty() && !formulaCharStack.peek().equals("(")) {
                    postfixFormula.add(formulaCharStack.pop());
                }

                formulaCharStack.pop();
            } else {
                postfixFormula.add(formulaSplit.get(i));
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
