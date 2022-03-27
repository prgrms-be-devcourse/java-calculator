package com.programmers.java.engine.service;

import com.programmers.java.engine.model.ValidFormula;

import java.util.*;

public class PostFixService {
    static StringBuilder sb;
    static Queue<String> operatorStack;

    public String[] makePostFixFormula(ValidFormula validFormula) {
        operatorStack = new LinkedList<>();
        sb = new StringBuilder();

        for (int i = 0; i < validFormula.getFormula().length; i++) {
            String str = validFormula.getFormula()[i];

            if (i % 2 == 0) sb.append(str).append(" ");

            else if (str.equals("*") || str.equals("/")) {
                sb.append(validFormula.getFormula()[i + 1]).append(" ");
                sb.append(str).append(" ");
                i += 1;
            } else {
                operatorStack.add(str);
            }
        }
        sb.append("^").append(" ");
        while (!operatorStack.isEmpty()) sb.append(operatorStack.poll()).append(" ");
        return sb.toString().split(" ");
    }
}