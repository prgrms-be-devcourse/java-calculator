package com.programmers.java.calculator.arithmetic;

import java.util.Map;

public class Validator {
    private final String ADD = "+";
    private final String SUB = "-";
    private final String MUL = "*";
    private final String DIV = "/";

    private final Map<String, Integer> priorityOfOpCode = Map.of(
            ADD,1,
            SUB,1,
            MUL,2,
            DIV,2
    );

    public Integer getPriority(String op) {
        return priorityOfOpCode.get(op);
    }

    public boolean isOperator(String op) {
        return op.equals(ADD) || op.equals(SUB) || op.equals(MUL) || op.equals(DIV);
    }

    public boolean isDecimal(String num) {
        String[] res = num.split("\\.");
        if (res.length == 1) return false;
        return !res[1].equals("0");
    }
}
