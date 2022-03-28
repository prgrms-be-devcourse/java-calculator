package com.programmers.java.engine.service;

import com.programmers.java.engine.model.Formula;

import java.util.*;

public class PostFixService {
    public String[] makePostFixFormula(Formula validFormula) {
        Stack<String> operatorStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < validFormula.getFormula().length; i++) {
            String str = validFormula.getFormula()[i];

            if (i % 2 == 0) {
                sb.append(str).append(" ");
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(str);
                } else if (OperatorPriority(str) >= OperatorPriority(operatorStack.peek())) {
                    while (!operatorStack.isEmpty() && OperatorPriority(str) >= OperatorPriority(operatorStack.peek())) {
                        sb.append(operatorStack.pop()).append(" ");
                    }
                    operatorStack.push(str);
                } else {
                    operatorStack.push(str);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            sb.append(operatorStack.pop()).append(" ");
        }
        return sb.toString().split(" ");
    }

    public int OperatorPriority(String operator) {
        int priority = 0;
        switch (operator) {
            case "+", "-" -> priority = 2;
            case "*", "/" -> priority = 1;
        }
        return priority;
    }
}