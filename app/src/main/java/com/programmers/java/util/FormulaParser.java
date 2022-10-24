package com.programmers.java.util;

import com.programmers.java.model.token.letter.bracket.CloseBracket;
import com.programmers.java.model.token.letter.bracket.OpenBracket;
import com.programmers.java.model.token.letter.operator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FormulaParser {
    public String[] changeInfixToPostfix(String formula) {
        Stack<String> stack = new Stack<>();
        String[] tokens = formula.split("((?=[-+/*()])|(?<=[-+/*()]))");

        List<String> postfixFormula = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (Operator.isOperator(token)) {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(token)) {
                    postfixFormula.add(stack.pop());
                }
                stack.push(token);
            } else if (OpenBracket.isOpen(token)) {
                stack.push(token);
            } else if (CloseBracket.isClose(token)) {
                while (!stack.isEmpty() && !OpenBracket.isOpen(stack.peek())) {
                    postfixFormula.add(stack.pop());
                }
                stack.pop();
            } else {
                postfixFormula.add(token);
            }
        }

        while (!stack.isEmpty()) {
            postfixFormula.add(stack.pop());
        }

        return postfixFormula.toArray(String[]::new);
    }

    public int getPriority(String operator) {
        if (MultiplyOperator.isMultiply(operator) || DivideOperator.isDivide(operator)) {
            return 2;
        } else if (PlusOperator.isPlus(operator) || MinusOperator.isMinus(operator)) {
            return 1;
        } else if (OpenBracket.isOpen(operator) || CloseBracket.isClose(operator)) {
            return 0;
        }

        return -1;
    }
}
